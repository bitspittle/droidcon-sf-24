package dev.bitspittle.droidconSf24.components.examples

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import org.jetbrains.compose.web.css.*

@Composable
fun ResponsivePreviews(modifier: Modifier = Modifier) {
    val borderRadius = Modifier.borderRadius(5.px)
    Row(modifier.fillMaxWidth().gap(2.cssRem), horizontalArrangement = Arrangement.Center) {
        Box(borderRadius.size(3.cssRem, 5.cssRem).backgroundColor(Colors.Red))
        Box(borderRadius.size(4.cssRem, 6.cssRem).backgroundColor(Colors.Yellow))
        Box(borderRadius.size(10.cssRem, 8.cssRem).backgroundColor(Colors.Green))
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
    30.percent { Modifier.backgroundColor(Colors.Yellow) }
    50.percent { Modifier.backgroundColor(Colors.Green) }
    each(70.percent, 100.percent) { Modifier.backgroundColor(Colors.Blue) }
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
