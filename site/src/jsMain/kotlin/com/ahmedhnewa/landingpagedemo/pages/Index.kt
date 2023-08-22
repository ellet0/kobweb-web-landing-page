package com.ahmedhnewa.landingpagedemo.pages

import androidx.compose.runtime.Composable
import com.ahmedhnewa.landingpagedemo.models.Section
import com.ahmedhnewa.landingpagedemo.utils.constants.Constants
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.maxHeight
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Section

@Page
@Composable
fun HomePage() {
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
    }
}
