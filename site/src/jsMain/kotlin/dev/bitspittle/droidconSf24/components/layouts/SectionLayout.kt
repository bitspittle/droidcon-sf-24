package dev.bitspittle.droidconSf24.components.layouts

import androidx.compose.runtime.*
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
import dev.bitspittle.droidconSf24.pages.PresentationAttrs
import dev.bitspittle.droidconSf24.pages.PresentationState
import dev.bitspittle.droidconSf24.styles.SiteColors
import dev.bitspittle.droidconSf24.utilities.heavyTextShadow
import dev.bitspittle.droidconSf24.utilities.walk
import kotlinx.dom.addClass
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Section
import org.w3c.dom.Element
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

private fun Enum<*>.toKebabCase(): String {
    return name.lowercase().replace("_", "-")
}

enum class Styles {
    // "outlined-headers": puts text shadow on h tags, useful when there's a background image
    OUTLINED_HEADERS,
    // "accented-subheaders": changes colors of h3 (and smaller) headers for better visual separation
    ACCENTED_SUBHEADERS;
}

enum class Behaviors {
    // "auto-fragment": automatically add fragment tags to relevant elements (to force a click through effect)
    //    If arguments are passed in, apply the fragment to those elements.
    //    Otherwise, apply to all top-level elements (except the first child, which is the header slide).
    AUTO_FRAGMENT,

    // "auto-progress-fragments": automatically run through all fragments without needing to click.
    //    If an argument is passed in, that will be that many milliseconds to wait. Otherwise, some relatively short wait.
    AUTO_PROGRESS_FRAGMENTS;
}

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

    val behaviors = md.frontMatter["behaviors"].orEmpty().map {
        val keyValue = it.split(" ", limit = 2)
        if (keyValue.size == 1) keyValue[0] to null else keyValue[0] to keyValue[1]
    }.toMap()

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

    if (behaviors.contains(Behaviors.AUTO_PROGRESS_FRAGMENTS.toKebabCase())) {
        PresentationState.AutoProgressSlides.add(md.path)
    }

    var containerElement by remember { mutableStateOf<HTMLElement?>(null) }
    containerElement?.let { element ->
        if (behaviors.contains(Behaviors.AUTO_FRAGMENT.toKebabCase())) {
            val args = behaviors[Behaviors.AUTO_FRAGMENT.toKebabCase()]?.split(",")?.map { it.trim() }?.toSet()

            fun Element.isMatch(): Boolean {
                return when (args) {
                    null -> this.parentElement == element && this != element.firstElementChild
                    else -> args.contains(this.nodeName)
                }
            }

            element.children.walk { child ->
                if (child.isMatch()) {
                    child.addClass("fragment")
                }
            }
        }
    }

    Section(
        attrs = SectionStyle
            .toModifier()
            .thenIf(styles.contains(Styles.OUTLINED_HEADERS.toKebabCase()), OutlinedHeadersStyle.toModifier())
            .thenIf(styles.contains(Styles.ACCENTED_SUBHEADERS.toKebabCase()), AccentedSubheadersStyle.toModifier())
            .toAttrs {
                dataAttrs.forEach { (key, value) -> attr(key, value) }
                attr(PresentationAttrs.SLIDE_PATH, md.path)
                behaviors[Behaviors.AUTO_PROGRESS_FRAGMENTS.toKebabCase()]?.let { arg ->
                    if (arg.toIntOrNull() != null) {
                        attr(PresentationAttrs.AUTO_PROGRESS_FRAGMENT_DURATION_MS, arg)
                    } else {
                        console.warn("Skipped invalid ${Behaviors.AUTO_PROGRESS_FRAGMENTS.toKebabCase()} arg \"$arg\", should be an int representing duration milliseconds")
                    }
                }

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
