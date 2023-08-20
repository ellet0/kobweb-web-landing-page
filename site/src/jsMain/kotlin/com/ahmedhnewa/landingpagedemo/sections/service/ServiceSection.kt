package com.ahmedhnewa.landingpagedemo.sections.service

import androidx.compose.runtime.Composable
import com.ahmedhnewa.landingpagedemo.components.SectionTitle
import com.ahmedhnewa.landingpagedemo.models.Section
import com.ahmedhnewa.landingpagedemo.sections.service.components.ServiceCard
import com.ahmedhnewa.landingpagedemo.sections.service.models.Service
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ServiceSection() = Box(
    modifier = Modifier.padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    ServiceContent()
}

@Composable
private fun ServiceContent() {
    // Could be optimized
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier.fillMaxWidth().margin(bottom = 20.px),
            section = Section.Service,
            alignment = Alignment.CenterHorizontally
        )
        ServiceCards()
    }
}

@Composable
private fun ServiceCards() {
    SimpleGrid(numColumns = numColumns(base = 1, sm = 2, md = 3)) {
        Service.values().forEach { ServiceCard(service = it) }
    }
}