package dev.bitspittle.droidconSf24.utilities

import org.w3c.dom.HTMLElement
import org.w3c.dom.MutationObserver
import org.w3c.dom.MutationObserverInit

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
