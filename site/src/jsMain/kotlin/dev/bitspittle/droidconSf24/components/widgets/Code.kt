package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Pre
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Code as JbCode

// See https://revealjs.com/code/
@Composable
fun Code(text: String, info: String? = null) {
    val infoSplit = info.orEmpty().split("|", limit = 2).map { it.takeUnless { it.isEmpty() } }
    val lang = infoSplit[0]
    val lines = if (infoSplit.size > 1) infoSplit[1] else null

    Pre {
        JbCode(attrs = {
            attr("data-trim", "")
            attr("data-noescape", "")
            lines?.let { attr("data-line-numbers", lines) }
            classes(lang?.let { "language-$it" } ?: "nohighlight")
        }) {
            Text(text)
        }
    }
}
