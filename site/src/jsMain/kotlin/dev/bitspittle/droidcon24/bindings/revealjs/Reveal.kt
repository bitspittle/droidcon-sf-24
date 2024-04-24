package dev.bitspittle.droidcon24.bindings.revealjs

import org.w3c.dom.Element
import kotlin.js.Json

external class Reveal(element: Element, options: Json) {
    fun initialize()
    fun destroy()
}
