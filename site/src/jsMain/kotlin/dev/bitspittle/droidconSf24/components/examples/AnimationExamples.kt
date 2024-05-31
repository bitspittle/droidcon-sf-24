package dev.bitspittle.droidconSf24.components.examples

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import dev.bitspittle.droidconSf24.components.widgets.Cursor
import dev.bitspittle.droidconSf24.styles.SiteColors
import org.jetbrains.compose.web.css.*

val AnimationTransitionColorKeyframes = Keyframes {
    each(0.percent, 45.percent) {
        Modifier.backgroundColor(Colors.Cyan)
    }

    each(50.percent, 85.percent) {
        Modifier.backgroundColor(Colors.Orange)
    }

    each(90.percent, 100.percent) {
        Modifier.backgroundColor(Colors.Cyan)
    }

}

val AnimationTransitionCursorKeyframes = Keyframes {
    each(0.percent, 40.percent) {
        Modifier.translate(5.cssRem, 1.cssRem)
    }

    each(50.percent, 78.percent) {
        Modifier.translate(1.cssRem, 1.cssRem)
    }

    each(88.percent, 100.percent) {
        Modifier.translate(5.cssRem, 1.cssRem)
    }
}

@Composable
fun TransitionExample(modifier: Modifier = Modifier) {
    Box(modifier.size(6.cssRem), contentAlignment = Alignment.Center) {
        Box(
            modifier.fillMaxSize().borderRadius(5.px).margin(top = 2.cssRem)
                .animation(
                    AnimationTransitionColorKeyframes.toAnimation(
                        5.s,
                        AnimationTimingFunction.Linear,
                        iterationCount = AnimationIterationCount.Infinite,
                    )
                )
        )

        Modifier.transition(Transition.of("background-color", 200.ms))
        Cursor(Modifier
            .animation(
                AnimationTransitionCursorKeyframes.toAnimation(
                    5.s,
                    AnimationTimingFunction.Linear,
                    iterationCount = AnimationIterationCount.Infinite,
                )
            )
        )
    }
}


val AnimationSpinningKeyframes = Keyframes {
    to { Modifier.rotate(360.deg) }
}

@Composable
fun SpinningExample(modifier: Modifier = Modifier) {
    Box(
        modifier.size(6.cssRem).borderRadius(5.px).margin(top = 2.cssRem).backgroundColor(SiteColors.KobwebBlue)
            .animation(
                AnimationSpinningKeyframes.toAnimation(
                    10.s,
                    AnimationTimingFunction.Linear,
                    iterationCount = AnimationIterationCount.Infinite,
                )
            )
    )
}

val AnimationSquashKeyframes = Keyframes {
    val left = Modifier.translateX((-10).cssRem).size(4.cssRem)
    val right = Modifier.translateX(10.cssRem).size(4.cssRem)
    val squishLeft = Modifier.size(2.cssRem, 6.cssRem).translateX((-11).cssRem)
    val squishRight = Modifier.size(2.cssRem, 6.cssRem).translateX(11.cssRem)

    0.percent { squishLeft }
    10.percent { left }
    40.percent { right }
    50.percent { squishRight }
    60.percent { right }
    90.percent { left }
    100.percent { squishLeft }
}

@Composable
fun SquashExample(modifier: Modifier = Modifier) {
    Box(modifier.margin(top = 2.cssRem).height(6.cssRem), contentAlignment = Alignment.Center) {
        Box(
            Modifier.borderRadius(50.percent).backgroundColor(SiteColors.KobwebBlue)
                .animation(
                    AnimationSquashKeyframes.toAnimation(
                        4.s,
                        AnimationTimingFunction.Linear,
                        iterationCount = AnimationIterationCount.Infinite,
                    )
                )
        )
    }
}

//val AnimationSpinningKeyframes = Keyframes {
//    from { Modifier.rotate(0.deg) }
//    to { Modifier.rotate(359.deg) }
//}
//
//@Composable
//fun SpinningExample(modifier: Modifier = Modifier) {
//    Box(
//        modifier.size(6.cssRem).borderRadius(5.px).margin(top = 2.cssRem).backgroundColor(SiteColors.KobwebBlue)
//            .animation(
//                AnimationSpinningKeyframes.toAnimation(
//                    10.s,
//                    AnimationTimingFunction.Linear,
//                    iterationCount = AnimationIterationCount.Infinite,
//                )
//            )
//    )
//}
