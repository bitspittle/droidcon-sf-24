package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img

@Composable
fun Image(src: String, scale: Number = 1.0) {
    Box(
        Modifier
            .backgroundColor(Colors.LightGray)
            .borderRadius(5.px)
            .margin(leftRight = 10.percent).padding(1.cssRem)
            .thenIf(scale.toDouble() < 1.0) { Modifier.scale(scale) }
    ) {
        Img("", attrs = {
            attr("data-src", "images/$src")
        })
    }
}
