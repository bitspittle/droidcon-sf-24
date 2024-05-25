package dev.bitspittle.droidconSf24.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSTextShadow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.borderLeft
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobwebx.markdown.markdown
import dev.bitspittle.droidconSf24.utilities.walk
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Section
import org.w3c.dom.HTMLHeadingElement

val SectionStyle = CssStyle {
    cssRule("blockquote") {
        Modifier
            .borderLeft(0.3.cssRem, LineStyle.Solid, Colors.DarkGray)
            .padding(left = 1.cssRem)
            .textAlign(TextAlign.Start)
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
