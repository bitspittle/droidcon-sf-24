package dev.bitspittle.droidconSf24.utilities

import com.varabyte.kobweb.compose.css.CSSLengthNumericValue
import com.varabyte.kobweb.compose.css.CSSTextShadow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.textShadow
import org.jetbrains.compose.web.css.px

// See https://revealjs.com/auto-animate/#how-elements-are-matched
fun Modifier.dataId(id: String) = attrsModifier {
    attr("data-id", id)
}

fun Modifier.attr(key: String, value: String) = attrsModifier {
    attr(key, value)
}

fun Modifier.heavyTextShadow(thickness: CSSLengthNumericValue = 20.px): Modifier {
    return listOf(
        (-1).px to (-1).px,
        (1).px to (-1).px,
        (-1).px to (1).px,
        (1).px to (1).px,
    )
        .map { CSSTextShadow(it.first, it.second, blurRadius = thickness, color = Colors.Black) }
        .let { shadows ->
            this.textShadow(*shadows.toTypedArray())
        }
}
