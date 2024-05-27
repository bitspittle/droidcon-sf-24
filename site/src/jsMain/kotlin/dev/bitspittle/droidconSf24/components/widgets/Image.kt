package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.JustifyItems
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img

@Composable
fun Image(src: String, scale: Number = 1.0, backgroundColor: Color? = null) {
    Box(
        Modifier
            .thenIf(backgroundColor != null) { Modifier.backgroundColor(backgroundColor!!) }
            .borderRadius(5.px)
            .margin(leftRight = 10.percent)
            .justifyItems(JustifyItems.Center)
            .alignItems(AlignItems.Center)
            .thenIf(scale.toDouble() < 1.0) { Modifier.scale(scale) }
    ) {
        Img("", attrs = Modifier.fillMaxSize().toAttrs {
            attr("data-src", "images/$src")
        })
    }
}
