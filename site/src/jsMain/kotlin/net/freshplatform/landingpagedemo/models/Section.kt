package net.freshplatform.landingpagedemo.models

import androidx.compose.runtime.Composable
import net.freshplatform.landingpagedemo.sections.MainSection

enum class Section(
    val id: String,
    val title: String,
    val subTitle: String,
    val path: String,
    val content: @Composable () -> Unit
) {
    Home(
        id = "home",
        title = "Home",
        subTitle = "",
        path = "#home",
        content = {MainSection()}
    ),
    About(
        id = "about",
        title = "About",
        subTitle = "",
        path = "#about",
        content = {MainSection()}
    ),
    Service(
        id = "service",
        title = "Service",
        subTitle = "",
        path = "#service",
        content = {MainSection()}
    ),
    Portfolio(
        id = "portfolio",
        title = "Portfolio",
        subTitle = "",
        path = "#portfolio",
        content = {MainSection()}
    ),
    Experience(
        id = "experience",
        title = "Experience",
        subTitle = "",
        path = "#experience",
        content = {MainSection()}
    ),
    Contact(
        id = "contact",
        title = "Contact",
        subTitle = "",
        path = "#contact",
        content = {MainSection()}
    ),
    Testimonial(
        id = "testimonial",
        title = "Testimonial",
        subTitle = "",
        path = "#testimonial",
        content = {MainSection()}
    ),
    Achievements(
        id = "achievements",
        title = "Achievements",
        subTitle = "",
        path = "#achievements",
        content = {MainSection()}
    );
    companion object {
        const val SECTION_TO_TAKE = 6
    }
}