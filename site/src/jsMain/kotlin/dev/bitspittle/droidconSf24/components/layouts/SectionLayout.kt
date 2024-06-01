package dev.bitspittle.droidconSf24.components.layouts

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.CSSTextShadow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobwebx.markdown.markdown
import dev.bitspittle.droidconSf24.components.widgets.Grid
import dev.bitspittle.droidconSf24.styles.SiteColors
import dev.bitspittle.droidconSf24.utilities.heavyTextShadow
import dev.bitspittle.droidconSf24.utilities.walk
import kotlinx.dom.addClass
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Section
import org.w3c.dom.HTMLElement

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
        Modifier.heavyTextShadow(20.px)
    }
}

val AccentedSubheadersStyle = CssStyle {
    cssRule(" :is(h3, h4, h5, h6)") {
        Modifier.color(SiteColors.Accent)
    }
}

private sealed interface Layout {
    data object Default : Layout
    data object Horizontal : Layout
    data class Grid(val numColumns: Int) : Layout

}

// layouts:
//   "horizontal": creates a row
//   "grid n": creates a simple grid of n columns
//
// styles:
//   "outlined-headers": puts text shadow on h tags, useful when there's a background image
//   "accented-subheaders": changes colors of h3 (and smaller) headers for better visual separation
//
// behaviors:
//   "auto-fragment": automatically add fragment tags to all top level elements (to force a click through effect)

@Composable
fun SectionLayout(content: @Composable () -> Unit) {
    val ctx = rememberPageContext()
    val md = ctx.markdown!!

    // Data attributes are a way to request behaviors from Reveal.js
    val dataAttrs = md.frontMatter.keys
        .filter { it.startsWith("data-") }
        .mapNotNull { dataKey ->
            val dataValueList = md.frontMatter[dataKey] ?: return@mapNotNull null
            val dataValue = dataValueList.singleOrNull().orEmpty()
            dataKey to dataValue
        } + buildList {
            add("data-auto-animate" to "")
            if (md.frontMatter.containsKey("follows")) {
                add("data-auto-animate-restart" to "")
            }
        }

    val behaviors = md.frontMatter["behaviors"].orEmpty().toSet()
    val styles = md.frontMatter["styles"].orEmpty().toSet()
    val layout = md.frontMatter["layout"]?.singleOrNull()?.let { layoutStr ->
        val layoutStrAndArgs = layoutStr.trim().split(" ")
        when (layoutStrAndArgs[0]) {
            Layout.Horizontal::class.simpleName!!.lowercase() -> Layout.Horizontal
            Layout.Grid::class.simpleName!!.lowercase() -> Layout.Grid(layoutStrAndArgs[1].toInt())
            else -> {
                console.warn("Ignored unrecognized layout \"$layoutStr\"")
                null
            }
        }
    } ?: Layout.Default

    var containerElement by remember { mutableStateOf<HTMLElement?>(null) }
    containerElement?.let { element ->
        if (behaviors.contains("auto-fragment")) {
            element.children.walk { child ->
                if (child.parentElement == element && child != element.firstElementChild) {
                    child.addClass("fragment fade-in")
                }
            }
        }
    }

    Section(
        attrs = SectionStyle
            .toModifier()
            .thenIf(styles.contains("outlined-headers"), OutlinedHeadersStyle.toModifier())
            .thenIf(styles.contains("accented-subheaders"), AccentedSubheadersStyle.toModifier())
            .toAttrs {
                dataAttrs.forEach { (key, value) -> attr(key, value) }
                if (layout is Layout.Default) {
                    ref { containerElement = it; onDispose { } }
                }
            }
    ) {
        when (layout) {
            is Layout.Horizontal -> {
                Div(Modifier
                    .display(DisplayStyle.Grid)
                    .gridTemplateColumns { repeat(autoFit) { minmax(0.px, 1.fr) } }
                    .gap(1.cssRem)
                    .toAttrs { ref { containerElement = it; onDispose { } } }) {
                    content()
                }
            }

            is Layout.Grid -> {
                Grid(layout.numColumns, ref = { containerElement = it }) {
                    content()
                }
            }

            else -> content()
        }
    }
}
