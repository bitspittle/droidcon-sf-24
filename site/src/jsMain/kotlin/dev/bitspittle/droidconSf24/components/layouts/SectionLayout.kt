package dev.bitspittle.droidconSf24.components.layouts

import androidx.compose.runtime.Composable
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
import dev.bitspittle.droidconSf24.utilities.walk
import kotlinx.dom.addClass
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Section
import org.w3c.dom.HTMLElement

val SectionStyle = CssStyle {
    base {
        Modifier.padding(leftRight = 5.percent) // Make sure sections always breath on the margins
    }

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

val AccentedSubheadersStyle = CssStyle {
    cssRule(" :is(h3, h4, h5, h6)") {
        Modifier.color(Colors.LightSlateGray)
    }
}

private fun HTMLElement.autoAddFragments() {
    val element = this

    element.children.walk { child ->
        if (child.parentElement == element && child !=  element.firstElementChild) {
            child.addClass("fragment fade-in")
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
            val dataValueList = md.frontMatter[dataKey] ?: return@mapNotNull null
            val dataValue = dataValueList.singleOrNull().orEmpty()
            dataKey to dataValue
        }

    val styles = md.frontMatter["styles"].orEmpty().toSet()

    Section(
        attrs = SectionStyle
            .toModifier()
            .thenIf(styles.contains("outlined-headers"), OutlinedHeadersStyle.toModifier())
            .thenIf(styles.contains("accented-subheaders"), AccentedSubheadersStyle.toModifier())
            .toAttrs {
                dataAttrs.forEach { (key, value) -> attr(key, value) }
                if (styles.contains("auto-fragment") && !styles.contains("horizontal")) {
                    ref { element ->
                        element.autoAddFragments()
                        onDispose {  }
                    }
                }
            }
    ) {
        if (styles.contains("horizontal")) {
            Div(Modifier
                .display(DisplayStyle.Grid)
                .gridTemplateColumns { repeat(autoFit) { minmax(0.px, 1.fr) } }
                .gap(1.cssRem)
                .toAttrs {
                    if (styles.contains("auto-fragment")) {
                        ref { element ->
                            element.autoAddFragments()
                            onDispose {  }
                        }
                    }
                }) {
                content()
            }
        } else content()
    }
}
