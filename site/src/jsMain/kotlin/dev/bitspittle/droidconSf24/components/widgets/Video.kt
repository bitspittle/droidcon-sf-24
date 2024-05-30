package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Video

@Composable
fun Video(src: String, modifier: Modifier = Modifier, autoplay: Boolean = true) {
    Box {
        Video(attrs = modifier.fillMaxSize().toAttrs {
            attr("data-src", "videos/$src")
            if (autoplay) { attr("data-autoplay", "") }
        })
    }
}
