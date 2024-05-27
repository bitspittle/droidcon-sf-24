package dev.bitspittle.droidconSf24

import com.varabyte.kobweb.core.AppGlobals

val AppGlobals.showSlideNumbers: Boolean get() = get("show-slide-numbers").toBoolean()
val AppGlobals.rememberLastSlide: Boolean get() = get("remember-last-slide").toBoolean()
