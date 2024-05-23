package dev.bitspittle.droidconSf24.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.dom.disposableRef
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.userSelect
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import dev.bitspittle.droidconSf24.bindings.revealjs.Reveal
import dev.bitspittle.droidconSf24.bindings.revealjs.RevealHighlight
import dev.bitspittle.droidconSf24.pages.sections.AgendaPage
import dev.bitspittle.droidconSf24.pages.sections.TitlePage
import dev.bitspittle.droidconSf24.pages.sections.industry.Part1Page
import org.jetbrains.compose.web.dom.Div
import kotlin.js.json

@InitSilk
fun initSilk(ctx: InitSilkContext) {
    ctx.stylesheet.apply {
        // Disable text selection as we don't need it for slides
        registerStyleBase("body") {
            Modifier.userSelect(UserSelect.None)
        }
    }
}

@Page
@Composable
fun HomePage() {
    Box(Modifier.fillMaxSize().classNames("reveal"),
        contentAlignment = Alignment.Center,
        ref = disposableRef { element ->
            println("Initializing reveal.js...")

            val deck = Reveal(
                element,
                json(
                    "embedded" to false,
                    "plugins" to arrayOf(RevealHighlight) // imported in build.gradle.kts
                )
            ).apply {
                initialize()
            }

            println("... initialized!")

            onDispose {
                println("Cleaning up reveal.js...")
                deck.destroy()
                println("... cleaned up!")
            }
        }
    ) {
        Div(Modifier.classNames("slides").toAttrs()) {
            TitlePage()
            AgendaPage()
            Part1Page()
        }
    }
}
