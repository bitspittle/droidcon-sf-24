package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div

// https://revealjs.com/layout/#stretch
@Composable
fun Spacer() {
    Div(attrs = { classes("r-stretch") })
}
