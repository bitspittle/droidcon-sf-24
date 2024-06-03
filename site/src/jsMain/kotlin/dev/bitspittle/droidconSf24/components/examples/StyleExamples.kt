package dev.bitspittle.droidconSf24.components.examples

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.*
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import dev.bitspittle.droidconSf24.components.widgets.Cursor
import org.jetbrains.compose.web.css.*

val HoverColorKeyframes = Keyframes {
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

val HoverCursorKeyframes = Keyframes {
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
fun HoverExample(modifier: Modifier = Modifier) {
    Box(modifier.size(6.cssRem), contentAlignment = Alignment.Center) {
        Box(
            modifier.fillMaxSize().borderRadius(5.px).margin(top = 2.cssRem).animation(
                    HoverColorKeyframes.toAnimation(
                        5.s,
                        AnimationTimingFunction.StepStart,
                        iterationCount = AnimationIterationCount.Infinite,
                    )
                )
        )

        Modifier.transition(Transition.of("background-color", 200.ms))
        Cursor(
            Modifier.animation(
                    HoverCursorKeyframes.toAnimation(
                        5.s,
                        AnimationTimingFunction.Linear,
                        iterationCount = AnimationIterationCount.Infinite,
                    )
                )
        )
    }
}

val ColoredSquareStyle = CssStyle.base {
    Modifier
        .size(6.cssRem)
        .borderRadius(5.px)
        .backgroundColor(Colors.Orange)
}

val RotatedSquareStyle = ColoredSquareStyle.extendedByBase {
    Modifier
        .rotate(45.deg)
        .backgroundColor(Colors.Cyan)
}


@Composable
fun RotatedRectExample(modifier: Modifier = Modifier) {
    Row(modifier.margin(top = 2.cssRem).gap(4.cssRem)) {
        Box(ColoredSquareStyle.toModifier())
        Box(RotatedSquareStyle.toModifier())
    }
}
