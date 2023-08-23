package com.ahmedhnewa.landingpagedemo.sections.experience

import androidx.compose.runtime.*
import com.ahmedhnewa.landingpagedemo.components.SectionTitle
import com.ahmedhnewa.landingpagedemo.models.Section
import com.ahmedhnewa.landingpagedemo.sections.experience.componenets.ExperienceCard
import com.ahmedhnewa.landingpagedemo.sections.experience.models.Experience
import com.ahmedhnewa.landingpagedemo.utils.ObserveViewportEntered
import com.ahmedhnewa.landingpagedemo.utils.constants.Constants
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ExperienceSection() = Box(
    modifier = Modifier
        .padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    ExperienceContent()
}

@Composable
private fun ExperienceContent() {
    val breakpoint = rememberBreakpoint()

    var animatedMargin by remember { mutableStateOf(200) }

    if (Constants.ANIMATION_ENABLED) {
        ObserveViewportEntered(
            sectionId = Section.Experience.id,
            distanceFromTop = 500.0,
        ) {
            animatedMargin = 50
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier.margin(bottom = 25.px)
                .fillMaxWidth(
                    if (breakpoint >= Breakpoint.MD) 60.percent
                    else 90.percent
                ),
            section = Section.Experience,
        )
        val experiences = Experience.values()
        experiences.forEach { experience ->
            ExperienceCard(
                isActive = experience == experiences.first(),
                experience = experience,
                breakpoint = breakpoint,
                animatedMargin = animatedMargin.px
            )
        }
    }
}