package dev.bitspittle.droidconSf24

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.core.KobwebApp
import com.varabyte.kobweb.silk.prepareSilkFoundation

@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    KobwebApp {
        prepareSilkFoundation {
            content()
        }
    }
}
