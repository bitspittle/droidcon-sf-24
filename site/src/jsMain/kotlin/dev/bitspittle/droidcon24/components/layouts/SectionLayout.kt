package dev.bitspittle.droidcon24.components.layouts

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Section

@Composable
fun SectionLayout(content: @Composable () -> Unit) {
    Section {
        content()
    }
}
