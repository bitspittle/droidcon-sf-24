package dev.bitspittle.droidcon24.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Pre
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Code as JbCode

// See https://revealjs.com/code/
@Composable
fun Code(text: String, lang: String? = null) {
    Pre {
        JbCode(attrs = {
            attr("data-trim", "")
            attr("data-noescape", "")
            classes(lang?.let { "language-$it" } ?: "nohighlight")
        }) {
            Text(text)
        }
    }
}
