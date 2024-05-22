package dev.bitspittle.droidconSf24.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobwebx.markdown.markdown
import org.jetbrains.compose.web.dom.Section

@Composable
fun SectionLayout(content: @Composable () -> Unit) {
    val ctx = rememberPageContext()
    val md = ctx.markdown!!

    // Data attributes are a way to request behaviors from Reveal.js
    val dataAttrs = md.frontMatter.keys
        .filter { it.startsWith("data-") }
        .mapNotNull { dataKey ->
            val dataValue = md.frontMatter[dataKey]?.single() ?: return@mapNotNull null
            dataKey to dataValue
        }

    Section(
        attrs = { dataAttrs.forEach { (key, value) -> attr(key, value) } }
    ) {
        content()
    }
}
