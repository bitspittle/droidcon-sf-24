package dev.bitspittle.droidconSf24.components.examples

import androidx.compose.runtime.*
import com.varabyte.kobweb.browser.util.setInterval
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
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

private val FakeColorButtonBgColor by StyleVariable<CSSColorValue>()
private val FakeColorButtonFgColor by StyleVariable<CSSColorValue>()
private val FakeColorBoxBgColor by StyleVariable<CSSColorValue>()

val FakeColorButtonContainerStyle = CssStyle.base {
    Modifier
        .size(8.cssRem)
        .borderRadius(1.cssRem)
        .backgroundColor(FakeColorButtonBgColor.value())
        .padding(2.cssRem)
        .border(1.px, LineStyle.Solid, FakeColorButtonFgColor.value())
        .transition(Transition.all(200.ms))
}

val FakeColorButtonStyle = CssStyle.base {
    Modifier
        .borderRadius(50.percent)
        .size(4.cssRem)
        .fontSize(2.cssRem)
        .backgroundColor(FakeColorButtonFgColor.value())
        .color(FakeColorButtonBgColor.value())
        .transition(Transition.all(200.ms))
}

val FakeColorBoxStyle = CssStyle.base {
    Modifier
        .borderRadius(4.px)
        .size(4.cssRem)
        .backgroundColor(FakeColorBoxBgColor.value())
        .transition(Transition.all(200.ms))
}


@Composable
private fun ColorContainer(modifier: Modifier = Modifier, content: @Composable (ColorMode) -> Unit) {
    var fakeColorMode by remember { mutableStateOf(ColorMode.LIGHT) }

    LaunchedEffect(Unit) {
        window.setInterval(4.seconds) {
            fakeColorMode = fakeColorMode.opposite
        }
    }

    Box(
        FakeColorButtonContainerStyle.toModifier().then(modifier)
            .setVariable(FakeColorButtonBgColor, if (fakeColorMode.isLight) Colors.SeaShell else Colors.Black)
            .setVariable(FakeColorButtonFgColor, if (fakeColorMode.isLight) Colors.Black else Colors.White),
        contentAlignment = Alignment.Center
    ) {
        content(fakeColorMode)
    }
}

@Composable
private fun _ColorModeButton(colorMode: ColorMode) {
    Box(
        FakeColorButtonStyle.toModifier(),
        contentAlignment = Alignment.Center
    ) {
        if (colorMode.isLight) FaMoon() else FaSun()
    }
}

@Composable
fun ColorModeButton(modifier: Modifier = Modifier) {
    ColorContainer(modifier) { colorMode -> _ColorModeButton(colorMode) }
}

@Composable
fun ColorModeButtonAndBox(modifier: Modifier = Modifier) {
    ColorContainer(modifier) { colorMode ->
        Row(Modifier.gap(2.cssRem)) {
            _ColorModeButton(colorMode)
            Box(
                FakeColorBoxStyle.toModifier()
                    .setVariable(FakeColorBoxBgColor, if (colorMode.isLight) Colors.DarkRed else Colors.Pink),
                contentAlignment = Alignment.Center
            )
        }
    }
}
