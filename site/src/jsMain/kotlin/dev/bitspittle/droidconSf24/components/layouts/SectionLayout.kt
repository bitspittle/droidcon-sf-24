package dev.bitspittle.droidconSf24.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSTextShadow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.borderLeft
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.textShadow
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobwebx.markdown.markdown
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Section

val SectionStyle = CssStyle {
    cssRule("blockquote") {
        Modifier
            .borderLeft(0.3.cssRem, LineStyle.Solid, Colors.DarkGray)
            .padding(left = 1.cssRem)
            .textAlign(TextAlign.Start)
    }
}

val OutlinedHeadersStyle = CssStyle {
    cssRule(" :is(h1, h2, h3, h4, h5, h6)") {
        listOf(
            (-1).px to (-1).px,
            (1).px to (-1).px,
            (-1).px to (1).px,
            (1).px to (1).px,
        )
            .map { CSSTextShadow(it.first, it.second, blurRadius = 20.px, color = Colors.Black) }
            .let { shadows ->
                Modifier.textShadow(*shadows.toTypedArray())
            }
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
        attrs = SectionStyle
            .toModifier()
            .thenIf(styles.contains("outlined-headers"), OutlinedHeadersStyle.toModifier())
            .toAttrs {
                dataAttrs.forEach { (key, value) -> attr(key, value) }
            }
    ) {
        content()
    }
}
