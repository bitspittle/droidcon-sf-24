package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Pre
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Code as JbCode

// See https://revealjs.com/code/
@Composable
fun Code(text: String, info: String? = null) {
    val infoSplit = info.orEmpty().split(" ").map { it.takeUnless { it.isEmpty() } }.toMutableList()
    val lang = infoSplit.removeFirst()
    val lines = if (infoSplit.isNotEmpty()) infoSplit.removeFirst() else null

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
