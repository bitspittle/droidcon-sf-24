package dev.bitspittle.droidconSf24

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.userSelect
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.core.KobwebApp
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import com.varabyte.kobweb.silk.prepareSilkFoundation
import com.varabyte.kobweb.silk.style.layer.SilkLayer
import com.varabyte.kobweb.silk.style.layer.add

@InitSilk
fun initSilk(ctx: InitSilkContext) {
    ctx.stylesheet.apply {
        // Layers specified in build.gradle.kts
        cssLayers.add("reveal", "highlightjs", after = SilkLayer.BASE)

        // Disable text selection as we don't need it for slides
        registerStyleBase("body") {
            Modifier.userSelect(UserSelect.None)
        }
    }
}

@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    KobwebApp {
        prepareSilkFoundation {
            content()
        }
    }
}
