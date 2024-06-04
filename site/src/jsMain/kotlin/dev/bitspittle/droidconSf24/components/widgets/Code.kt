package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.overflowX
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import com.varabyte.kobweb.silk.style.CssStyle
import dev.bitspittle.droidconSf24.styles.SiteColors
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Pre
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Code as JbCode

val HideVerticalScrollbar = CssStyle {
    cssRule("> code") {
        Modifier.overflow { y(Overflow.Clip) }
    }
}

@InitSilk
fun initCodeStyles(ctx: InitSilkContext) {
    ctx.stylesheet.apply {
        fun border(color: Color) = Modifier.border(5.px, LineStyle.Solid, color)

        registerStyleBase(".apibackend > code") { border(Colors.Gray) }
        registerStyleBase(".apifrontend > code") { border(SiteColors.KobwebBlue) }
        registerStyleBase(".apicommon > code") { border(Colors.LightGreen) }
    }
}

// See https://revealjs.com/code/
// Markdown code tags can contain (each optionally, but in order)...
// - line number highlights (see: https://revealjs.com/code/#line-numbers-%26-highlights)
// - class names: surrounded by <> and separated by commas (e.g. `<fragment,fade-down>`)
// - attributes: key/value pairs surrounded by {} and separated by commands (e.g. `{data-fragment-index=3,id=hello}`)
// - a data ID: surrounded by [] (e.g. `[kobweb-code]`)
@Composable
fun Code(text: String, info: String? = null) {
    val infoSplit = info.orEmpty().split(" ").mapNotNull { it.takeUnless { it.isEmpty() } }.toMutableList()
    val lang = infoSplit.removeFirstOrNull()
    val lines = if (infoSplit.isNotEmpty() && (infoSplit.first().first() !in listOf('[', '<', '{'))) infoSplit.removeFirst() else null
    val classes = if (infoSplit.firstOrNull()?.startsWith("<") == true) infoSplit.removeFirst().removePrefix("<").removeSuffix(">").split(",") else null
    val attrs = if (infoSplit.firstOrNull()?.startsWith("{") == true) infoSplit
        .removeFirst()
        .removePrefix("{").removeSuffix("}")
        .split(",").associate { attrsStr -> attrsStr.split('=').let { it[0] to it[1] } } else null
    val id = if (infoSplit.firstOrNull()?.startsWith("[") == true) infoSplit.removeFirst().removePrefix("[").removeSuffix("]") else null

    Pre(attrs = {
        classes?.let { classes(classes) }
        attrs?.forEach { (k, v) -> attr(k, v) }
    }) {
        JbCode(attrs = {
            attr("data-trim", "")
            attr("data-noescape", "")
            id?.let { attr("data-id", id) }
            lines?.let { attr("data-line-numbers", lines) }
            classes(lang?.let { "language-$it" } ?: "nohighlight")
            style {
                // We never want code to scroll horizontally
                // It's a presentation so the user can't ever see past the end!
                // With vertical scroll at least we can use code fragments to scroll.
                overflowX(Overflow.Clip)
            }
        }) {
            Text(text)
        }
    }
}
