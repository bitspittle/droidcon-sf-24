package dev.bitspittle.droidconSf24.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSTextShadow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.css.textShadow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.cssRules
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.theme.SilkTheme
import com.varabyte.kobwebx.markdown.markdown
import kotlinx.browser.document
import kotlinx.dom.addClass
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.StyleScopeBuilder
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Section
import org.w3c.dom.*
import org.w3c.dom.css.get

val SectionStyle = CssStyle {
    cssRule("blockquote") {
        Modifier
            .borderLeft(0.3.cssRem, LineStyle.Solid, Colors.DarkGray)
            .padding(left = 1.cssRem)
            .textAlign(TextAlign.Start)
    }
}

private fun HTMLCollection.walk(onEach: (Element) -> Unit) {
    (0 until length)
        .mapNotNull { i: Int -> this[i] }
        .forEach { child ->
            onEach(child)
            child.children.walk(onEach)
        }
}

private fun NodeList.walk(onEach: (Node) -> Unit) {
    (0 until length)
        .mapNotNull { i: Int -> this[i] }
        .forEach { node ->
            onEach(node)
            node.childNodes.walk(onEach)
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
        attrs = SectionStyle.toAttrs {
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
                    fun HTMLElement.styleListElement() {
                        // Inline styles required to override reveal-js list styles
                        style.listStyleType = "none"
                        style.fontFamily = "monospace"
                        style.color = Colors.LightGray.toString()
                    }

                    element.children.walk { child ->
                        when (child) {
                            is HTMLUListElement -> {
                                child.addClass("fa-ul")
                                child.styleListElement()
                            }
                            is HTMLOListElement -> {
                                child.addClass("fa-ol")
                                child.styleListElement()
                            }

                            is HTMLLIElement -> {
                                val span = document.createElement("span")
                                span.addClass("fa-li")
                                val i = document.createElement("i")
                                val childText = buildString {
                                    child.childNodes.walk { liChild ->
                                        if (liChild.parentNode == child && liChild is Text) {
                                            append(liChild.nodeValue.orEmpty())
                                        }
                                    }
                                }
                                i.addClass("fa-regular", when {
                                    childText.contains('.') -> "fa-file"
                                    child.children.length > 0 -> "fa-folder-open"
                                    else -> "fa-folder"
                                })
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
