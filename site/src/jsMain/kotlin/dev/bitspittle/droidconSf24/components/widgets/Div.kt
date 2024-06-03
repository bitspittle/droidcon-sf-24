package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Div as JbDiv

@Composable
fun Div(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    JbDiv(modifier.toAttrs()) {
        content()
    }
}
