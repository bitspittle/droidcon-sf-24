package dev.bitspittle.droidconSf24.components.examples

import androidx.compose.runtime.*
import com.varabyte.kobweb.browser.util.setInterval
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.fa.FaMoon
import com.varabyte.kobweb.silk.components.icons.fa.FaSun
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import kotlin.time.Duration.Companion.seconds

private val FakeColorBgColor by StyleVariable<CSSColorValue>()
private val FakeColorFgColor by StyleVariable<CSSColorValue>()

val FakeColorButtonContainerStyle = CssStyle.base {
    Modifier
        .size(8.cssRem)
        .borderRadius(1.cssRem)
        .backgroundColor(FakeColorBgColor.value())
        .padding(2.cssRem)
        .border(1.px, LineStyle.Solid, FakeColorFgColor.value())
        .transition(CSSTransition("all", 200.ms))
}

val FakeColorButtonStyle = CssStyle.base {
    Modifier
        .borderRadius(50.percent)
        .size(4.cssRem)
        .fontSize(2.cssRem)
        .backgroundColor(FakeColorFgColor.value())
        .color(FakeColorBgColor.value())
        .transition(CSSTransition("all", 200.ms))
}


@Composable
fun ColorModeBox(modifier: Modifier = Modifier) {
    var fakeColorMode by remember { mutableStateOf(ColorMode.LIGHT) }

    LaunchedEffect(Unit) {
        window.setInterval(4.seconds) {
            fakeColorMode = fakeColorMode.opposite
        }
    }

    Box(
        FakeColorButtonContainerStyle.toModifier().then(modifier)
            .setVariable(FakeColorBgColor, if (fakeColorMode.isLight) Colors.SeaShell else Colors.Black)
            .setVariable(FakeColorFgColor, if (fakeColorMode.isLight) Colors.Black else Colors.White),
        contentAlignment = Alignment.Center
    ) {
        Box(FakeColorButtonStyle.toModifier(),
            contentAlignment = Alignment.Center
        ) {
            if (fakeColorMode.isLight) FaMoon() else FaSun()
        }
    }
}
