package dev.bitspittle.droidcon24.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.disposableRef
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import dev.bitspittle.droidcon24.bindings.revealjs.Reveal
import dev.bitspittle.droidcon24.bindings.revealjs.RevealHighlight
import dev.bitspittle.droidcon24.pages.sections.*
import org.jetbrains.compose.web.dom.Div
import kotlin.js.json

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
            Slide1Page()
            Slide2Page()
        }
    }
}
