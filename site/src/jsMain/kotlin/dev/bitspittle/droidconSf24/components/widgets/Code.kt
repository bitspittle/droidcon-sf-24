package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Pre
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Code as JbCode

// See https://revealjs.com/code/
@Composable
fun Code(text: String, info: String? = null) {
    val infoSplit = info.orEmpty().split(" ").mapNotNull { it.takeUnless { it.isEmpty() } }.toMutableList()
    val lang = infoSplit.removeFirstOrNull()
    val lines = if (infoSplit.isNotEmpty() && !infoSplit.first().startsWith("[")) infoSplit.removeFirst() else null
    val id = if (infoSplit.isNotEmpty()) infoSplit.removeFirst().removePrefix("[").removeSuffix("]") else null

    Pre {
        JbCode(attrs = {
            attr("data-trim", "")
            attr("data-noescape", "")
            id?.let { attr("data-id", id) }
            lines?.let { attr("data-line-numbers", lines) }
            classes(lang?.let { "language-$it" } ?: "nohighlight")
        }) {
            Text(text)
        }
    }
}
