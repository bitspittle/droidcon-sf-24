package dev.bitspittle.droidconSf24.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSTextShadow
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.css.textShadow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.textShadow
import com.varabyte.kobweb.compose.ui.modifiers.userSelect
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.theme.SilkTheme
import com.varabyte.kobwebx.markdown.markdown
import kotlinx.browser.document
import kotlinx.dom.addClass
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.css.StyleScopeBuilder
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Section
import org.w3c.dom.*
import org.w3c.dom.css.get

private val TextShadowModifier = Modifier
    .textShadow(
        CSSTextShadow(0.px, 0.px, blurRadius = 5.px, color = Colors.Black)
    )

private fun HTMLCollection.walk(onEach: (Element) -> Unit) {
    (0 until length)
        .mapNotNull { i: Int -> this[i] }
        .forEach { child ->
            onEach(child)
            child.children.walk(onEach)
        }
}

@Composable
fun SectionLayout(content: @Composable () -> Unit) {
    val ctx = rememberPageContext()
    val md = ctx.markdown!!

    // Data attributes are a way to request behaviors from Reveal.js
    val dataAttrs = md.frontMatter.keys
        .filter { it.startsWith("data-") }
        .mapNotNull { dataKey ->
            val dataValue = md.frontMatter[dataKey]?.single() ?: return@mapNotNull null
            dataKey to dataValue
        }

    val styles = md.frontMatter["styles"].orEmpty().toSet()

    Section(
        attrs = {
            dataAttrs.forEach { (key, value) -> attr(key, value) }
            ref { element ->

                // Convert
                //
                // <ul>
                //   <li>Hi!</li>
                // </ul>
                //
                // to:
                //
                // <ul class="fa-ul">
                //   <li><span class="fa-li"><i class="fa-solid fa-folder"></i></span>Hi!</li>
                //</ul>
                if (styles.contains("folders")) {
                    element.children.walk { child ->
                        when (child) {
                            is HTMLUListElement -> {
                                child.addClass("fa-ul")
                                // Have to override reveal-js list styles
                                child.style.listStyleType = "none"
                            }
                            is HTMLOListElement -> {
                                child.addClass("fa-ol")
                                // Have to override reveal-js list styles
                                child.style.listStyleType = "none"
                            }

                            is HTMLLIElement -> {
                                val span = document.createElement("span")
                                span.addClass("fa-li")
                                val i = document.createElement("i")
                                i.addClass("fa-regular", "fa-folder")
                                span.appendChild(i)
                                child.insertBefore(span, child.firstChild)
                            }
                        }
                    }
                }

                if (styles.contains("outlined-headers")) {
                    element.children.walk { child ->
                        when (child) {
                            is HTMLHeadingElement -> {
                                child.style.textShadow =
                                    listOf(
                                        (-1).px to (-1).px,
                                        (1).px to (-1).px,
                                        (-1).px to (1).px,
                                        (1).px to (1).px,
                                    )
                                        .map { CSSTextShadow(it.first, it.second, blurRadius = 20.px, color = Colors.Black) }
                                        .joinToString()
                            }
                        }
                    }
                }

                onDispose {  }
            }
        }
    ) {
        content()
    }
}
