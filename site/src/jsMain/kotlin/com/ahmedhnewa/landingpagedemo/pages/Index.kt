package com.ahmedhnewa.landingpagedemo.pages

import androidx.compose.runtime.Composable
import com.ahmedhnewa.landingpagedemo.components.BackToTopButton
import com.ahmedhnewa.landingpagedemo.models.Section
import com.ahmedhnewa.landingpagedemo.sections.footer.FooterSection
import com.ahmedhnewa.landingpagedemo.utils.constants.Constants
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Footer
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Text

@Page
@Composable
fun HomePage() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        BackToTopButton()
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Section.values().forEach {
                Section(
                    attrs = Modifier
                        .maxHeight(Constants.SECTION_MAX_HEIGHT.px)
                        .fillMaxWidth()
                        .id(it.id)
                        .toAttrs()
                ) {
                    it.content()
                }
            }
//            Footer(
//                attrs = Modifier.fillMaxWidth().toAttrs()
//            ) {
//                FooterSection()
//            }
        }
    }
}
