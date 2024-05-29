package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ListStyleType
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignContent
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.listStyle
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import dev.bitspittle.droidconSf24.utilities.walk
import kotlinx.browser.document
import kotlinx.dom.addClass
import org.jetbrains.compose.web.css.AlignContent
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLLIElement
import org.w3c.dom.HTMLOListElement
import org.w3c.dom.HTMLUListElement
import org.w3c.dom.Text

val FoldersStyle = CssStyle {
    base {
        Modifier
            .fontFamily("monospace")
            .listStyle(ListStyleType.None)
            .textAlign(TextAlign.Start)
            .alignContent(AlignContent.Center)
    }
}

@Composable
fun Folders(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Span(attrs = FoldersStyle.toModifier().then(modifier).toAttrs {
        ref { element ->
            element.children.walk { child ->
                when (child) {
                    is HTMLUListElement -> {
                        child.addClass("fa-ul")
                    }

                    is HTMLOListElement -> {
                        child.addClass("fa-ol")
                    }

                    is HTMLLIElement -> {
                        val span = document.createElement("span")
                        span.addClass("fa-li")
                        val i = document.createElement("i")
                        val childText = buildString {
                            child.childNodes.walk { liChild ->
                                if (liChild.parentNode == child && liChild is Text) {
                                    append(liChild.nodeValue.orEmpty())
                                }
                            }
                        }
                        i.addClass(
                            "fa-regular", when {
                                childText.contains('.') -> "fa-file"
                                child.children.length > 0 -> "fa-folder-open"
                                else -> "fa-folder"
                            }
                        )
                        span.appendChild(i)
                        child.insertBefore(span, child.firstChild)
                    }
                }
            }

            onDispose { }
        }
    }) {
        content()
    }
}
