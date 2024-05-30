package dev.bitspittle.droidconSf24.components.examples

import androidx.compose.runtime.*
import com.varabyte.kobweb.browser.dom.ElementTarget
import com.varabyte.kobweb.browser.util.CancellableActionHandle
import com.varabyte.kobweb.browser.util.invokeLater
import com.varabyte.kobweb.browser.util.setInterval
import com.varabyte.kobweb.browser.util.setTimeout
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.disclosure.Tabs
import com.varabyte.kobweb.silk.components.forms.*
import com.varabyte.kobweb.silk.components.overlay.AdvancedTooltip
import com.varabyte.kobweb.silk.components.overlay.OpenClosePopupStrategy
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.components.overlay.manual
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.bitspittle.droidconSf24.components.widgets.Horizontal
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

@Composable
fun ResponsivePreviews(modifier: Modifier = Modifier) {
    val borderRadius = Modifier.borderRadius(5.px)
    Row(modifier.fillMaxWidth().gap(2.cssRem), horizontalArrangement = Arrangement.Center) {
        Box(borderRadius.size(3.cssRem, 5.cssRem).backgroundColor(Colors.Red))
        Box(borderRadius.size(9.cssRem, 8.cssRem).backgroundColor(Colors.Green))
        Box(borderRadius.size(16.cssRem, 8.cssRem).backgroundColor(Colors.Blue))
    }
}

val ResponsiveResizingKeyframesSize = Keyframes {
    each(0.percent, 20.percent) { Modifier.width(3.cssRem).height(5.cssRem) }
    50.percent { Modifier.width(9.cssRem).height(8.cssRem) }
    each(80.percent, 100.percent) { Modifier.width(16.cssRem).height(8.cssRem) }
}

val ResponsiveResizingKeyframesColor = Keyframes {
    0.percent { Modifier.backgroundColor(Colors.Red) }
    40.percent { Modifier.backgroundColor(Colors.Green) }
    each(60.percent, 100.percent) { Modifier.backgroundColor(Colors.Blue) }
}

@Composable
fun AnimatedResponsiveExample(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxWidth().height(8.cssRem), contentAlignment = Alignment.Center) {
        Box(
            Modifier.borderRadius(5.px)
                .animation(
                    ResponsiveResizingKeyframesSize.toAnimation(
                        5.s,
                        AnimationTimingFunction.Linear,
                        iterationCount = AnimationIterationCount.Infinite,
                        direction = AnimationDirection.Alternate
                    ),
                    ResponsiveResizingKeyframesColor.toAnimation(
                        5.s,
                        AnimationTimingFunction.StepEnd,
                        iterationCount = AnimationIterationCount.Infinite,
                        direction = AnimationDirection.Alternate
                    )
                )
        )
    }
}

@Composable
fun ResponsiveExample(modifier: Modifier = Modifier) {
    val borderRadius = Modifier.borderRadius(5.px)
    Row(modifier.fillMaxWidth().gap(2.cssRem), horizontalArrangement = Arrangement.Center) {
        Box(borderRadius.size(3.cssRem, 5.cssRem).backgroundColor(Colors.Red))
        Box(borderRadius.size(9.cssRem, 8.cssRem).backgroundColor(Colors.Green))
        Box(borderRadius.size(16.cssRem, 8.cssRem).backgroundColor(Colors.Blue))
    }
}
