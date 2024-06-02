package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Span as JbSpan

@Composable
fun Span(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    JbSpan(modifier.toAttrs()) {
        content()
    }
}
