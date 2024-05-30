package dev.bitspittle.droidconSf24

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.userSelect
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import com.varabyte.kobweb.silk.style.layer.SilkLayer
import com.varabyte.kobweb.silk.style.layer.add
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem

@InitSilk
fun initSilk(ctx: InitSilkContext) {
    ctx.config.initialColorMode = ColorMode.DARK

    ctx.stylesheet.apply {
        // Layers specified in build.gradle.kts
        cssLayers.add("highlightjs", "revealjs", after = SilkLayer.BASE)

        // Disable text selection as we don't need it for slides
        registerStyleBase("body") {
            Modifier.userSelect(UserSelect.None)
        }

        // Hack because somehow some code is inserting an invalid ".hljs-ln td" style into my styles.
        // Reveal.js works around this by defining its own style on top of it, but that's getting lost because I put
        // their styles into a lower-precedence layer.
        registerStyleBase(".hljs-ln td") {
            Modifier.padding { right(1.cssRem) }
        }

        registerStyleBase("td.hljs-ln-line.hljs-ln-numbers") {
            Modifier.display(DisplayStyle.None)
        }
    }
}

@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    SilkApp {
        content()
    }
}
