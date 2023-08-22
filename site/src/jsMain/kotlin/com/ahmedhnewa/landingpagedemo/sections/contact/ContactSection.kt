package com.ahmedhnewa.landingpagedemo.sections.contact

import androidx.compose.runtime.*
import com.ahmedhnewa.landingpagedemo.components.SectionTitle
import com.ahmedhnewa.landingpagedemo.models.Section
import com.ahmedhnewa.landingpagedemo.sections.contact.components.ContactForm
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.TextInput

@Composable
fun ContactSection() = Box(
    modifier = Modifier
        .padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    ContactContent()
}

@Composable
private fun ContactContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 100.percent
            else 90.percent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 20.px),
            section = Section.Contact,
            alignment = Alignment.CenterHorizontally
        )
        ContactForm()
    }
}

