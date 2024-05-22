package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.DisplayStyle

// See https://revealjs.com/fragments/
@Composable
fun Fragment(classes: String, text: String) {
    SpanText(text, Modifier.classNames("fragment", "custom", classes).display(DisplayStyle.InlineBlock))
}
