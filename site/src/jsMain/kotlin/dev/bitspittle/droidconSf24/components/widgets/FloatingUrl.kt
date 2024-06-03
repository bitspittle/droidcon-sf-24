package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRotateRight
import com.varabyte.kobweb.silk.style.*
import dev.bitspittle.droidconSf24.styles.SiteColors
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Span as JbSpan

val FloatingUrlStyle = CssStyle.base {
    Modifier
        .position(Position.Absolute)
        .left(0.px)
        .right(0.px)
}

@Composable
fun FloatingUrl(url: String, modifier: Modifier = Modifier) {
    A(url, FloatingUrlStyle.toAttrs()) {
        Text(url)
    }
}
