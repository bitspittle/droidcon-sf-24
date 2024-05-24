package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Aside

// See https://revealjs.com/speaker-view/
@Composable
fun SpeakerNotes(content: @Composable () -> Unit) {
    Aside(attrs = {
        classes("notes")
    }) {
        content()
    }
}
