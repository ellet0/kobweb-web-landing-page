package com.ahmedhnewa.landingpagedemo.models

import androidx.compose.runtime.Composable
import com.ahmedhnewa.landingpagedemo.sections.about.AboutSection
import com.ahmedhnewa.landingpagedemo.sections.achievement.AchievementSection
import com.ahmedhnewa.landingpagedemo.sections.contact.ContactSection
import com.ahmedhnewa.landingpagedemo.sections.experience.ExperienceSection
import com.ahmedhnewa.landingpagedemo.sections.main.MainSection
import com.ahmedhnewa.landingpagedemo.sections.portfolio.PortfolioSection
import com.ahmedhnewa.landingpagedemo.sections.service.ServiceSection
import com.ahmedhnewa.landingpagedemo.sections.testimonial.TestimonialSection
import org.jetbrains.compose.web.dom.Text

enum class Section(
    val id: String,
    val title: String,
    val subtitle: String,
    val path: String,
    val content: @Composable () -> Unit = { Text("No content yet") }
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
        subtitle = "What can I do?",
        path = "#service",
        content = { ServiceSection() }
    ),
    Portfolio(
        id = "portfolio",
        title = "Portfolio",
        subtitle = "My projects",
        path = "#portfolio",
        content = { PortfolioSection() }
    ),
    Achievements(
        id = "achievements",
        title = "Achievements",
        subtitle = "",
        path = "#achievements",
        content = { AchievementSection() }
    ),
    Testimonial(
        id = "testimonial",
        title = "Testimonial",
        subtitle = "Customers reviews (fake)",
        path = "#testimonial",
        content = { TestimonialSection() }
    ),
    Experience(
        id = "experience",
        title = "Experience",
        subtitle = "Work Experience (fake)",
        path = "#experience",
        content = { ExperienceSection() }
    ),
    Contact(
        id = "contact",
        title = "Contact",
        subtitle = "Get in Touch",
        path = "#contact",
        content = { ContactSection() }
    );

    companion object {
//        const val SECTION_TO_TAKE = 6

        // In header
        val navigationItems = listOf(Home, About, Service, Portfolio, Experience, Contact)
    }
}