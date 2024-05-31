package dev.bitspittle.droidconSf24.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext

@InitSilk
fun initSilk(ctx: InitSilkContext) {
    ctx.stylesheet.apply {
        registerStyle(".fragment.highlight-kobweb") {
            cssRule(".visible") { Modifier.color(SiteColors.KobwebBlue) }
        }

        registerStyle(".fragment.highlight-kotlin") {
            cssRule(".visible") { Modifier.color(SiteColors.KotlinPurple) }
        }
    }
}

object SiteColors {
    val KobwebBlue = Color.rgb(0x4285f4)
    val KotlinPurple = Color.rgb(0x7f52ff)
    val AndroidGreen = Color.rgb(0x3DDC84)
    val Accent = Colors.LightBlue
}
