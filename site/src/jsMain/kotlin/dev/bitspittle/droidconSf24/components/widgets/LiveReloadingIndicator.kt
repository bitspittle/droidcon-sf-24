package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

val SpinAnimation = Keyframes {
    from { Modifier.rotate(0.deg) }
    to { Modifier.rotate(359.deg) }
}

val LiveReloadingIndicatorStyle = CssStyle.base {
    Modifier
        .fontSize(2.cssRem)
        .backgroundColor(Colors.WhiteSmoke)
        .color(Colors.Black)
        .padding(0.8.cssRem)
        .border(1.px, LineStyle.Solid, Colors.Black)
        .borderRadius(10.px)
}

val LiveReloadingIndicatorSpinningWebStyle = CssStyle.base {
    Modifier.animation(
        SpinAnimation.toAnimation(
            colorMode,
            1.5.s,
            timingFunction = AnimationTimingFunction.Linear,
            iterationCount = AnimationIterationCount.Infinite
        )
    )
        .color(Colors.Gray)
        .display(DisplayStyle.InlineBlock) // Needed for rotation to apply
}

val LiveReloadingIndicatorTextStyle = CssStyle.base {
    Modifier.margin(left = 0.5.cssRem).color(Colors.Black).fontStyle(FontStyle.Italic)
}

//     <div id="status">
//      <span id="warning">❌</span><span id="spinner">&#128376;️</span> <span id="text"></span>
//
//      <style>
//        @keyframes kobweb-spin {
//            from { transform: rotate(0deg); }
//            to { transform: rotate(359deg); }
//        }
//        body > #status {
//            position: fixed;
//            font-size: 24px;
//            background: whitesmoke;
//            top: 20px;
//            left: 50%;
//            transform: translateX(-50%);
//            padding: 10px;
//            border: 1px solid;
//            border-radius: 10px;
//            visibility: hidden;
//            opacity: 0;
//            z-index: 2147483647;
//            user-select: none;
//        }
//        body > #status > .hidden {
//           display: none;
//        }
//        body > #status > .visible {
//            display: inline-block;
//        }
//        body > #status.fade-in {
//            visibility: visible;
//            opacity: 1;
//            transition: opacity 1s;
//        }
//        body > #status.fade-out {
//           visibility: hidden;
//           opacity: 0;
//           transition: visibility 0s 1s, opacity 1s;
//        }
//        body > #status > #spinner {
//            animation: kobweb-spin 1.5s linear infinite;
//        }
//    </style>

@Composable
fun LiveReloadingIndicator() {
    //     <div id="status">
//      <span id="warning">❌</span><span id="spinner">&#128376;️</span> <span id="text"></span>

    Box(contentAlignment = Alignment.Center) {
        Div(LiveReloadingIndicatorStyle.toAttrs()) {
            SpanText("\uD83D\uDD78\uFE0F", LiveReloadingIndicatorSpinningWebStyle.toModifier())
            SpanText("Building...", LiveReloadingIndicatorTextStyle.toModifier())
        }
    }
}
