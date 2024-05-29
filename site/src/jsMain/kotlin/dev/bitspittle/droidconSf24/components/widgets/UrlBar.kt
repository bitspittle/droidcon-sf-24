package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
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
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

val UrlBarContainerStyle = CssStyle.base {
    Modifier
        .borderRadius(5.px)
        .backgroundColor(SiteColors.KobwebBlue)
        .gap(1.cssRem)
        .padding(leftRight = 1.cssRem, topBottom = 0.4.cssRem)
}

val UrlAreaStyle = CssStyle.base {
    Modifier
        .borderRadius(10.px)
        .backgroundColor(Colors.DarkSlateGrey)
        .fontFamily("monospace")
        .fontSize(1.3.cssRem)
        .padding(leftRight = 0.7.cssRem, topBottom = 0.2.cssRem)
        .flexGrow(1)
}

val UrlIconStyle = CssStyle.base {
    Modifier
        .color(Colors.White.copyf(alpha = 0.8f))
        .fontSize(1.5.cssRem)
}

val DisabledUrlIconStyle = UrlIconStyle.extendedByBase {
    Modifier.color(Colors.LightGray.copyf(alpha = 0.6f))
}

@Composable
fun UrlBar(url: String, modifier: Modifier = Modifier, id: String? = null) {
    Box(contentAlignment = Alignment.Center) {
        Row(
            UrlBarContainerStyle.toModifier().thenIf(id != null, Modifier.attrsModifier { attr("data-id", id!!) })
                .then(modifier),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            FaArrowLeft(DisabledUrlIconStyle.toModifier())
            FaArrowRight(DisabledUrlIconStyle.toModifier())
            FaArrowRotateRight(UrlIconStyle.toModifier())
            Box(UrlAreaStyle.toModifier()) {
                Text(if (url.contains("://")) url else "https://$url")
            }
        }
    }
}
