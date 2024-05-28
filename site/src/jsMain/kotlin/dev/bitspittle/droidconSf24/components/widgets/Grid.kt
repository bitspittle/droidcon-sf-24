package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateColumns
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateRows
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLElement

@Composable
fun Grid(numColumns: Int, ref: ((HTMLElement) -> Unit)? = null, content: @Composable () -> Unit) {
    Div(
        Modifier
            .display(DisplayStyle.Grid)
            .gridTemplateColumns { repeat(numColumns) { minmax(0.px, 1.fr) } }
            .gridTemplateRows { repeat(autoFit) { minmax(0.px, 1.fr) } }
            .gap(0.5.cssRem)
            .toAttrs {
                if (ref != null) {
                    ref { ref(it); onDispose { } }
                }
            }) {
        content()
    }
}
