package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSLengthNumericValue
import com.varabyte.kobweb.compose.css.JustifyItems
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img

val ImageStyle = CssStyle.base {
    Modifier
        .borderRadius(5.px)
        .margin(leftRight = 10.percent)
        .justifyItems(JustifyItems.Center)
        .alignItems(AlignItems.Center)
}

@Composable
private fun _Image(src: String) {
    Img("", attrs = Modifier.fillMaxSize().toAttrs {
        attr("data-src", "images/$src")
    })
}

@Composable
fun Image(src: String, scale: Number = 1.0, backgroundColor: Color? = null) {
    Box(
        ImageStyle.toModifier()
            .thenIf(backgroundColor != null) { Modifier.backgroundColor(backgroundColor!!) }
            .thenIf(scale.toDouble() < 1.0) { Modifier.scale(scale) }
    ) {
        _Image(src)
    }
}
