package net.freshplatform.landingpagedemo.models

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import net.freshplatform.landingpagedemo.sections.main.MainSection
import net.freshplatform.landingpagedemo.utils.constants.Constants
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

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
        content = { MainSection() }
    ),
    About(
        id = "about",
        title = "About",
        subTitle = "",
        path = "#about",

        content = { Text("Hi") }
    ),
    Service(
        id = "service",
        title = "Service",
        subTitle = "",
        path = "#service",
        content = { Text("Service") }
    ),
    Portfolio(
        id = "portfolio",
        title = "Portfolio",
        subTitle = "",
        path = "#portfolio",
        content = { Text("Portfolio") }
    ),
    Experience(
        id = "experience",
        title = "Experience",
        subTitle = "",
        path = "#experience",
        content = { Text("Experience") }
    ),
    Contact(
        id = "contact",
        title = "Contact",
        subTitle = "",
        path = "#contact",
        content = { Text("Contact") }
    ),
    Testimonial(
        id = "testimonial",
        title = "Testimonial",
        subTitle = "",
        path = "#testimonial",
        content = { Text("Testimonial") }
    ),
    Achievements(
        id = "achievements",
        title = "Achievements",
        subTitle = "",
        path = "#achievements",
        content = { Text("Achievements") }
    );
    companion object {
        const val SECTION_TO_TAKE = 6
    }
}