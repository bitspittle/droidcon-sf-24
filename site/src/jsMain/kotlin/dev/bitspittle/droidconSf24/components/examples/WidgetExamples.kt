package dev.bitspittle.droidconSf24.components.examples

import androidx.compose.runtime.*
import com.varabyte.kobweb.browser.dom.ElementTarget
import com.varabyte.kobweb.browser.util.CancellableActionHandle
import com.varabyte.kobweb.browser.util.setInterval
import com.varabyte.kobweb.compose.dom.ref
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.disclosure.Tabs
import com.varabyte.kobweb.silk.components.forms.*
import com.varabyte.kobweb.silk.components.overlay.AdvancedTooltip
import com.varabyte.kobweb.silk.components.overlay.OpenClosePopupStrategy
import com.varabyte.kobweb.silk.components.overlay.manual
import dev.bitspittle.droidconSf24.utilities.onSlideVisibilityChanged
import kotlinx.browser.window
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

@Composable
fun ButtonExample(modifier: Modifier = Modifier) {
    Button(onClick = {}, modifier, size = ButtonSize.LG) {
        Text("Click me!")
    }
}

@Composable
fun CheckboxExample(modifier: Modifier = Modifier) {
    var checked by remember { mutableStateOf(false) }

    var isSlideVisible by remember { mutableStateOf(false) }
    DisposableEffect(isSlideVisible) {
        var handle: CancellableActionHandle? = null
        if (isSlideVisible) {
            handle = window.setInterval(2.seconds) {
                checked = !checked
            }
        }

        onDispose {
            handle?.cancel()
            checked = false
        }
    }

    // Weird jumping glitch with reveal.js + checkbox, put in a box to buffer
    Box(
        Modifier.height(5.cssRem),
        contentAlignment = Alignment.Center,
        ref = ref { element -> element.onSlideVisibilityChanged { isSlideVisible = it } }
    ) {
        Checkbox(checked, onCheckedChange = { }, modifier, size = CheckboxSize.LG) {
            Text("Check me!")
        }
    }
}

@Composable
fun InputExample(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    val target = "Hello!!!"

    var isSlideVisible by remember { mutableStateOf(false) }
    DisposableEffect(isSlideVisible) {
        var handle: CancellableActionHandle? = null
        if (isSlideVisible) {
            handle = window.setInterval(initialDelay = 4.seconds, 300.milliseconds) {
                text = target.substring(0, text.length + 1)
                if (text == target) {
                    handle?.cancel()
                }
            }
        }

        onDispose {
            handle?.cancel()
            text = ""
        }
    }

    TextInput(
        text,
        onTextChanged = {},
        modifier,
        placeholder = "Type here",
        ref = ref { element -> element.onSlideVisibilityChanged { isSlideVisible = it } })
}

@Composable
fun TabExample(modifier: Modifier = Modifier) {
    var currTab by remember { mutableStateOf(0) }

    var isSlideVisible by remember { mutableStateOf(false) }
    DisposableEffect(isSlideVisible) {
        var handle: CancellableActionHandle? = null
        if (isSlideVisible) {
            handle = window.setInterval(2.seconds) {
                currTab = (currTab + 1) % 3
            }
        }

        onDispose {
            handle?.cancel()
            currTab = 0
        }
    }

    Tabs(modifier, ref = ref { element -> element.onSlideVisibilityChanged { isSlideVisible = it } }) {
        TabPanel(isDefault = (currTab == 0)) {
            Tab { Text("Tab 1") }; Panel { Text("Panel 1") }
        }
        TabPanel(isDefault = (currTab == 1)) {
            Tab { Text("Tab 2") }; Panel { Text("Panel 2") }
        }
        TabPanel(isDefault = (currTab == 2)) {
            Tab { Text("Tab 3") }; Panel { Text("Panel 3") }
        }
    }
}

@Composable
fun TooltipExample(modifier: Modifier = Modifier) {
    val tooltipStrategy = remember { OpenClosePopupStrategy.manual() }

    var isSlideVisible by remember { mutableStateOf(false) }
    DisposableEffect(isSlideVisible) {
        var handle: CancellableActionHandle? = null
        if (isSlideVisible) {
            handle = window.setInterval(initialDelay = 2.seconds, 4.seconds) {
                tooltipStrategy.isOpen = !tooltipStrategy.isOpen
            }
        }
        onDispose {
            handle?.cancel()
            tooltipStrategy.isOpen = false
        }
    }

    Div(Modifier.size(4.cssRem).backgroundColor(Colors.Cyan).borderRadius(5.px).toAttrs {
        ref { element ->
            element.onSlideVisibilityChanged { isSlideVisible = it }
            onDispose {  }
        }
    })
    AdvancedTooltip(ElementTarget.PreviousSibling, "Hello!!!", modifier, openCloseStrategy = tooltipStrategy)
}
