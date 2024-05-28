package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import dev.bitspittle.droidconSf24.styles.SiteColors

val KobwebTextStyle = CssStyle.base {
    Modifier.color(SiteColors.KobwebBlue)
}

@Composable
fun KobwebText(text: String) {
    SpanText(text, KobwebTextStyle.toModifier())
}


@Composable
fun Kobweb() {
    KobwebText("Kobweb")
}
