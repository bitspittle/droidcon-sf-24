package dev.bitspittle.droidconSf24.utilities

import org.w3c.dom.*

fun HTMLCollection.walk(onEach: (Element) -> Unit) {
    (0 until length)
        .mapNotNull { i: Int -> this[i] }
        .forEach { child ->
            onEach(child)
            child.children.walk(onEach)
        }
}

fun NodeList.walk(onEach: (Node) -> Unit) {
    (0 until length)
        .mapNotNull { i: Int -> this[i] }
        .forEach { node ->
            onEach(node)
            node.childNodes.walk(onEach)
        }
}

val HTMLElement.ancestors: Sequence<HTMLElement>
    get() {
        var curr: HTMLElement? = this
        return sequence {
            while (curr != null) {
                yield(curr!!)
                curr = curr!!.parentElement as? HTMLElement
            }
        }
    }
