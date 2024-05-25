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
