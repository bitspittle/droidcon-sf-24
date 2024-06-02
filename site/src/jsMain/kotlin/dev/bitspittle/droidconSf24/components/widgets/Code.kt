package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.overflowX
import org.jetbrains.compose.web.dom.Pre
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Code as JbCode

// See https://revealjs.com/code/
@Composable
fun Code(text: String, info: String? = null) {
    val infoSplit = info.orEmpty().split(" ").mapNotNull { it.takeUnless { it.isEmpty() } }.toMutableList()
    val lang = infoSplit.removeFirstOrNull()
    val lines = if (infoSplit.isNotEmpty() && (infoSplit.first().first() !in listOf('[', '<'))) infoSplit.removeFirst() else null
    val classes = if (infoSplit.firstOrNull()?.startsWith("<") == true) infoSplit.removeFirst().removePrefix("<").removeSuffix(">") else null
    val id = if (infoSplit.firstOrNull()?.startsWith("[") == true) infoSplit.removeFirst().removePrefix("[").removeSuffix("]") else null

    Pre(attrs = {
        classes?.let { classes(classes) }
    }) {
        JbCode(attrs = {
            attr("data-trim", "")
            attr("data-noescape", "")
            id?.let { attr("data-id", id) }
            lines?.let { attr("data-line-numbers", lines) }
            classes(lang?.let { "language-$it" } ?: "nohighlight")
            style {
                // We never want code to scroll horizontally
                // It's a presentation so the user can't ever see past the end!
                // With vertical scroll at least we can use code fragments to scroll.
                overflowX(Overflow.Clip)
            }
        }) {
            Text(text)
        }
    }
}
