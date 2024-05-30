package dev.bitspittle.droidconSf24.components.examples

import androidx.compose.runtime.*
import com.varabyte.kobweb.browser.dom.ElementTarget
import com.varabyte.kobweb.browser.util.CancellableActionHandle
import com.varabyte.kobweb.browser.util.invokeLater
import com.varabyte.kobweb.browser.util.setInterval
import com.varabyte.kobweb.browser.util.setTimeout
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.disclosure.Tabs
import com.varabyte.kobweb.silk.components.forms.*
import com.varabyte.kobweb.silk.components.overlay.AdvancedTooltip
import com.varabyte.kobweb.silk.components.overlay.OpenClosePopupStrategy
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.components.overlay.manual
import com.varabyte.kobweb.silk.theme.colors.ColorMode
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

    LaunchedEffect(Unit) {
        window.setInterval(2.seconds) {
            checked = !checked
        }
    }

    // Weird jumping glitch with reveal.js + checkbox, put in a box to buffer
    Box(Modifier.height(5.cssRem), contentAlignment = Alignment.Center) {
        Checkbox(checked, onCheckedChange = { }, modifier, size = CheckboxSize.LG) {
            Text("Check me!")
        }
    }
}

@Composable
fun InputExample(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    val target = "Hello!!!"

    LaunchedEffect(Unit) {
        lateinit var handle: CancellableActionHandle
        handle = window.setInterval(initialDelay = 4.seconds, 300.milliseconds) {
            text = target.substring(0, text.length + 1)
            if (text == target) {
                handle.cancel()
            }
        }
    }

    TextInput(text, onTextChanged = {}, modifier, placeholder = "Type here")
}

@Composable
fun TabExample(modifier: Modifier = Modifier) {
    var currTab by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        window.setInterval(2.seconds) {
            currTab = (currTab + 1) % 3
        }
    }

    Tabs(modifier) {
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

    LaunchedEffect(Unit) {
        window.setTimeout(2.seconds) {
            tooltipStrategy.isOpen = true
        }

        window.setTimeout(4.seconds) {
            tooltipStrategy.isOpen = false
        }
    }

    Div(Modifier.size(4.cssRem).backgroundColor(Colors.Cyan).borderRadius(5.px).toAttrs())
    AdvancedTooltip(ElementTarget.PreviousSibling, "Hello!!!", modifier, openCloseStrategy = tooltipStrategy)
}
