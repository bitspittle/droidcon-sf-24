package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.RoutePrefix
import org.jetbrains.compose.web.dom.Img

@Composable
fun Image(src: String) {
    Img(RoutePrefix.prepend(src))
}
