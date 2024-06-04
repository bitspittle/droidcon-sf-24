package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ListStyleType
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.descendants
import com.varabyte.kobweb.silk.style.toModifier
import dev.bitspittle.droidconSf24.styles.SiteColors
import dev.bitspittle.droidconSf24.utilities.walk
import kotlinx.browser.document
import kotlinx.dom.addClass
import kotlinx.dom.hasClass
import org.jetbrains.compose.web.css.AlignContent
import org.jetbrains.compose.web.dom.Div
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

    descendants(".filename") { Modifier.color(Colors.LightSkyBlue) }
}

@Composable
fun Folders(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Div(attrs = FoldersStyle.toModifier().then(modifier).toAttrs {
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
                        val iconSpan = document.createElement("span")
                        iconSpan.addClass("fa-li")
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
                        iconSpan.appendChild(i)
                        val nameNode = child.firstChild!!
                        child.insertBefore(iconSpan, nameNode)
                        if (i.hasClass("fa-file")) {
                            val filenameSpan = document.createElement("span")
                            filenameSpan.addClass("filename")
                            nameNode.parentNode!!.insertBefore(filenameSpan, nameNode)
                            filenameSpan.append(nameNode)
                        }
                    }
                }
            }

            onDispose { }
        }
    }) {
        content()
    }
}
