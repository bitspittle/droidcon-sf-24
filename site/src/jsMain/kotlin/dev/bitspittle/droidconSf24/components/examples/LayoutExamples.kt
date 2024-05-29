package dev.bitspittle.droidconSf24.components.examples

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@Composable
fun BoxInBox(modifier: Modifier = Modifier) {
    Box(
        modifier
            .size(8.cssRem)
            .backgroundColor(Colors.Cyan),
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .size(4.cssRem)
                .backgroundColor(Colors.Blue),
        )
    }
}

@Composable
fun BoxesInRow(modifier: Modifier = Modifier) {
    Row(
        modifier
            .padding(leftRight = 2.cssRem)
            .gap(2.cssRem)
            .height(8.cssRem)
            .backgroundColor(Colors.Cyan),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(Modifier.size(4.cssRem).backgroundColor(Colors.Blue))
        Box(Modifier.size(4.cssRem).backgroundColor(Colors.Pink))
        Box(Modifier.size(4.cssRem).backgroundColor(Colors.Green))
    }
}
