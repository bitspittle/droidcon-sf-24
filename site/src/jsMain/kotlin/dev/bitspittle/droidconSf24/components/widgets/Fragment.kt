package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.silk.components.text.SpanText

// See https://revealjs.com/fragments/
@Composable
fun Fragment(classes: String, text: String) {
    SpanText(text, Modifier.classNames("fragment", "custom", classes))
}
