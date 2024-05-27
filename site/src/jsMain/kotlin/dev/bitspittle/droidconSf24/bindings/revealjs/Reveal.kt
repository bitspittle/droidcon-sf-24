package dev.bitspittle.droidconSf24.bindings.revealjs

import org.w3c.dom.Element
import kotlin.js.Json

external class Reveal(element: Element, options: Json) {
    // Lifecycle
    fun initialize()
    fun destroy()

    // Events
    fun on(evt: String, action: () -> Unit)

    // Slides
    fun slide(indexh: Int, indexv: Int, indexf: Int = definedExternally)
    fun getIndices(): Json
}
