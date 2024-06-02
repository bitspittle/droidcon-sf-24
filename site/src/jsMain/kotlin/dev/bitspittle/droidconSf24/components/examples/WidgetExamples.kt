package dev.bitspittle.droidconSf24.components.examples

import androidx.compose.runtime.*
import com.varabyte.kobweb.browser.dom.ElementTarget
import com.varabyte.kobweb.browser.util.CancellableActionHandle
import com.varabyte.kobweb.browser.util.setInterval
import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.dom.registerRefScope
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.disclosure.Tabs
import com.varabyte.kobweb.silk.components.forms.*
import com.varabyte.kobweb.silk.components.overlay.AdvancedTooltip
import com.varabyte.kobweb.silk.components.overlay.OpenClosePopupStrategy
import com.varabyte.kobweb.silk.components.overlay.manual
import dev.bitspittle.droidconSf24.utilities.SlideLifecycleEffect
import dev.bitspittle.droidconSf24.utilities.intoSlideLifecycleRef
import dev.bitspittle.droidconSf24.utilities.rememberElementState
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
fun ShadowedButtonExample(modifier: Modifier = Modifier) {
    Button(onClick = {}, modifier.boxShadow(BoxShadow.of(
        blurRadius = 0.5.cssRem, spreadRadius = 0.2.cssRem, color = Colors.Yellow
    )), size = ButtonSize.LG) {
        Text("Click me!")
    }
}

@Composable
fun CheckboxExample(modifier: Modifier = Modifier) {
    var checked by remember { mutableStateOf(false) }

    val elementState = rememberElementState()
    SlideLifecycleEffect(elementState, reset = { checked = false }) {
        window.setInterval(2.seconds) {
            checked = !checked
        }
    }

    // Weird jumping glitch with reveal.js + checkbox, put in a box to buffer
    Box(
        Modifier.height(5.cssRem),
        contentAlignment = Alignment.Center,
        ref = elementState.intoSlideLifecycleRef()
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

    val elementState = rememberElementState()
    SlideLifecycleEffect(elementState, reset = { text = "" }) {
        lateinit var handle: CancellableActionHandle
        handle = window.setInterval(initialDelay = 4.seconds, 300.milliseconds) {
            text = target.substring(0, text.length + 1)
            if (text == target) {
                handle.cancel()
            }
        }
        handle
    }

    TextInput(
        text,
        onTextChanged = {},
        modifier,
        placeholder = "Type here",
        ref = elementState.intoSlideLifecycleRef()
    )
}

@Composable
fun InputVariantsExample(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    val target = "Hello!!!"

    val elementState = rememberElementState()
    SlideLifecycleEffect(elementState, reset = { text = "" }) {
        lateinit var handle: CancellableActionHandle
        handle = window.setInterval(initialDelay = 2.seconds, 200.milliseconds) {
            text = target.substring(0, text.length + 1)
            if (text == target) {
                handle.cancel()
            }
        }
        handle
    }

    Column(modifier.gap(0.5.cssRem), ref = elementState.intoSlideLifecycleRef()) {
        TextInput(
            text,
            placeholder = "outlined",
            variant = OutlinedInputVariant,
            onTextChanged = {},
        )
        TextInput(
            text,
            placeholder = "filled",
            variant = FilledInputVariant,
            onTextChanged = {},
        )
        TextInput(
            text,
            placeholder = "flushed",
            variant = FlushedInputVariant,
            onTextChanged = {},
        )
        TextInput(
            text,
            placeholder = "unstyled",
            variant = UnstyledInputVariant,
            onTextChanged = {},
        )
    }
}

@Composable
fun TabExample(modifier: Modifier = Modifier) {
    var currTab by remember { mutableStateOf(0) }

    val elementState = rememberElementState()
    SlideLifecycleEffect(elementState, reset = { currTab = 0 }) {
        window.setInterval(2.seconds) {
            currTab = (currTab + 1) % 3
        }
    }

    Tabs(modifier, ref = elementState.intoSlideLifecycleRef()) {
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

    val elementState = rememberElementState()
    SlideLifecycleEffect(elementState, reset = { tooltipStrategy.isOpen = false }) {
        window.setInterval(initialDelay = 2.seconds, 4.seconds) {
            tooltipStrategy.isOpen = !tooltipStrategy.isOpen
        }
    }

    Div(Modifier.size(4.cssRem).backgroundColor(Colors.Cyan).borderRadius(5.px).toAttrs()) {
        registerRefScope(elementState.intoSlideLifecycleRef())
    }
    AdvancedTooltip(ElementTarget.PreviousSibling, "Hello!!!", modifier, openCloseStrategy = tooltipStrategy)
}
