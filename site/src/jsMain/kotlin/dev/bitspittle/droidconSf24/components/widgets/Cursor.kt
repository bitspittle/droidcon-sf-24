package dev.bitspittle.droidconSf24.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowPointer
import dev.bitspittle.droidconSf24.utilities.heavyTextShadow
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Pre
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Code as JbCode

@Composable
fun Cursor(modifier: Modifier) {
    FaArrowPointer(modifier.heavyTextShadow(2.px))
}
