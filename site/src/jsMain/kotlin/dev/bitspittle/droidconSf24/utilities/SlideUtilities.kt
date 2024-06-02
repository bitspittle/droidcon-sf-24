package dev.bitspittle.droidconSf24.utilities

import androidx.compose.runtime.*
import com.varabyte.kobweb.browser.util.CancellableActionHandle
import com.varabyte.kobweb.compose.dom.ElementRefScope
import com.varabyte.kobweb.compose.dom.ref
import org.w3c.dom.HTMLElement
import org.w3c.dom.MutationObserver
import org.w3c.dom.MutationObserverInit
import kotlin.math.absoluteValue

fun HTMLElement.onSlideVisibilityChanged(callback: (Boolean) -> Unit) {
    var isVisible = false

    val parentSection = this.ancestors.firstOrNull { it.nodeName == "SECTION" }
    if (parentSection != null) {
        val observer = MutationObserver { mutations, _ ->
            mutations.forEach { mutation ->
                if (mutation.type == "attributes" && mutation.attributeName == "class") {
                    val classNames = (mutation.target as HTMLElement).className.split(" ").toSet()
                    var isVisibleCurr = false
                    if (classNames.contains("present")) {
                        isVisibleCurr = true
                    }

                    if (isVisible != isVisibleCurr) {
                        callback(isVisibleCurr)
                        isVisible = isVisibleCurr
                    }
                }
            }
        }

        observer.observe(parentSection, MutationObserverInit(attributes = true))
    }
}

@Composable
fun rememberElementState() = remember { mutableStateOf<HTMLElement?>(null) }

fun MutableState<HTMLElement?>.intoSlideLifecycleRef(): ElementRefScope<HTMLElement> {
    return ref { element -> this.value = element }
}

@Composable
fun SlideLifecycleEffect(
    elementState: MutableState<HTMLElement?>,
    reset: () -> Unit = {},
    disposableEffect: () -> CancellableActionHandle,
) {
    var isSlideVisible by remember { mutableStateOf(false) }
    elementState.value?.let { element ->
        DisposableEffect(isSlideVisible) {
            var handle: CancellableActionHandle? = null
            if (isSlideVisible) {
                println("STARTING 0x${element.hashCode().absoluteValue.toString(16)}")

                reset()
                handle = disposableEffect()
            }

            onDispose {
                handle?.let { handle ->
                    handle.cancel()
                    reset()
                }
            }
        }

        element.onSlideVisibilityChanged { isSlideVisible = it }
    }
}
