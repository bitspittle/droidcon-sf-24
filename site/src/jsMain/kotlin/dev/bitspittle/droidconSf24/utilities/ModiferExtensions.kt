package dev.bitspittle.droidconSf24.utilities

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier

// See https://revealjs.com/auto-animate/#how-elements-are-matched
fun Modifier.dataId(id: String) = attrsModifier {
    attr("data-id", id)
}
