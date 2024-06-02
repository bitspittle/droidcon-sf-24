package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.ref
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnDefaults
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import org.w3c.dom.HTMLElement

@Composable
fun Vertical(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = ColumnDefaults.VerticalArrangement,
    horizontalAlignment: Alignment.Horizontal = ColumnDefaults.HorizontalAlignment,
    ref: ((HTMLElement) -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Column(
        modifier,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
        ref = ref { element -> ref?.invoke(element) },
        content = { content() })
}
