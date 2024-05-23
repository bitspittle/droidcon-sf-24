package dev.bitspittle.droidconSf24.components.sections

import androidx.compose.runtime.Composable
import dev.bitspittle.droidconSf24.pages.sections.industry.*
import org.jetbrains.compose.web.dom.Section

@Composable
fun StateOfTheIndustrySlides() {
    HeaderPage()
    Section {
        KmpPage()
        Kmp2Page()
        Kmp3Page()
    }
    CmpPage()
}
