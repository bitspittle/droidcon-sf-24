package dev.bitspittle.droidconSf24.components.examples

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.css.CSSLengthNumericValue
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.theme.SilkTheme
import com.varabyte.kobweb.silk.theme.name
import dev.bitspittle.droidconSf24.utilities.SlideLifecycleEffect
import dev.bitspittle.droidconSf24.utilities.intoSlideLifecycleRef
import dev.bitspittle.droidconSf24.utilities.rememberElementState
import org.jetbrains.compose.web.css.*

val ResponsiveTargetTranslateXVar by StyleVariable<CSSLengthNumericValue>()

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

val AnimatePreviewsResizeStyle = CssStyle.base {
    Modifier.animation(
        ResponsiveResizingKeyframesSize.toAnimation(
            colorMode,
            5.s,
            AnimationTimingFunction.Linear,
            iterationCount = AnimationIterationCount.of(3),
            direction = AnimationDirection.Alternate
        ),
        ResponsiveResizingKeyframesColor.toAnimation(
            colorMode,
            5.s,
            AnimationTimingFunction.StepEnd,
            iterationCount = AnimationIterationCount.of(3),
            direction = AnimationDirection.Alternate
        )
    )
}

val ExplodePreviewsKeyframes = Keyframes {
    each(0.percent, 40.percent) { Modifier.translateX(0.px) }
    100.percent { Modifier.translateX(ResponsiveTargetTranslateXVar.value()) }
}

val AnimatePreviewsExplodeStyle = CssStyle.base {
    Modifier.animation(ExplodePreviewsKeyframes.toAnimation(colorMode, 1.s, fillMode = AnimationFillMode.Forwards))
}

enum class AnimationPart {
     OFF,
    RESIZING,
    EXPLODING,
}

@Composable
fun AnimatedResponsiveExample(modifier: Modifier = Modifier) {
    val elementState = rememberElementState()
    var animationPart by remember { mutableStateOf(AnimationPart.OFF) }

    SlideLifecycleEffect(elementState, reset = { animationPart = AnimationPart.OFF }) {
        animationPart = AnimationPart.RESIZING
        null
    }

    val borderRadius = Modifier.borderRadius(5.px)

    Box(
        modifier.fillMaxWidth().height(8.cssRem),
        contentAlignment = Alignment.Center,
        ref = elementState.intoSlideLifecycleRef()
    ) {
        if (animationPart == AnimationPart.RESIZING) {
            Box(
                borderRadius.onAnimationEnd {
                    animationPart = AnimationPart.EXPLODING
                }.classNames(AnimatePreviewsResizeStyle.name)
            )
        } else if (animationPart == AnimationPart.EXPLODING) {
            val animatedClass = borderRadius.classNames(AnimatePreviewsExplodeStyle.name)
            Box(
                animatedClass.size(3.cssRem, 5.cssRem).backgroundColor(Colors.Red)
                    .setVariable(ResponsiveTargetTranslateXVar, (-16.5).cssRem)
            )
            Box(
                animatedClass.size(4.cssRem, 6.cssRem).backgroundColor(Colors.Yellow)
                    .setVariable(ResponsiveTargetTranslateXVar, (-12).cssRem)
            )
            Box(
                animatedClass.size(10.cssRem, 8.cssRem).backgroundColor(Colors.Green)
                    .setVariable(ResponsiveTargetTranslateXVar, (-4).cssRem)
            )
            Box(
                animatedClass.size(16.cssRem, 8.cssRem).backgroundColor(Colors.Blue)
                    .setVariable(ResponsiveTargetTranslateXVar, (10).cssRem)
            )
        }
    }
}
