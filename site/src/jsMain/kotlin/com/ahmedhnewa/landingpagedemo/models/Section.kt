package com.ahmedhnewa.landingpagedemo.models

import androidx.compose.runtime.Composable
import com.ahmedhnewa.landingpagedemo.sections.about.AboutSection
import com.ahmedhnewa.landingpagedemo.sections.main.MainSection
import org.jetbrains.compose.web.dom.Text

enum class Section(
    val id: String,
    val title: String,
    val subtitle: String,
    val path: String,
    val content: @Composable () -> Unit
) {
    Home(
        id = "home",
        title = "Home",
        subtitle = "",
        path = "#home",
        content = { MainSection() }
    ),
    About(
        id = "about",
        title = "About",
        subtitle = "Why Hire Me?",
        path = "#about",
        content = { AboutSection() }
    ),
    Service(
        id = "service",
        title = "Service",
        subtitle = "",
        path = "#service",
        content = { Text("Service") }
    ),
    Portfolio(
        id = "portfolio",
        title = "Portfolio",
        subtitle = "",
        path = "#portfolio",
        content = { Text("Portfolio") }
    ),
    Experience(
        id = "experience",
        title = "Experience",
        subtitle = "",
        path = "#experience",
        content = { Text("Experience") }
    ),
    Contact(
        id = "contact",
        title = "Contact",
        subtitle = "",
        path = "#contact",
        content = { Text("Contact") }
    ),
    Testimonial(
        id = "testimonial",
        title = "Testimonial",
        subtitle = "",
        path = "#testimonial",
        content = { Text("Testimonial") }
    ),
    Achievements(
        id = "achievements",
        title = "Achievements",
        subtitle = "",
        path = "#achievements",
        content = { Text("Achievements") }
    );
    companion object {
        const val SECTION_TO_TAKE = 6
    }
}