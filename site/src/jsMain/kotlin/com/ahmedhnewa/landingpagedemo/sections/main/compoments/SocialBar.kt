package com.ahmedhnewa.landingpagedemo.sections.main.compoments

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.FaIcon
import com.varabyte.kobweb.silk.components.icons.fa.IconCategory
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import com.ahmedhnewa.landingpagedemo.models.Theme
import com.ahmedhnewa.landingpagedemo.utils.constants.Constants
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

@Composable
fun SocialBar(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.then(modifier)
            .margin(right = 25.px)
            .padding(topBottom = 25.px)
            .minWidth(40.px)
            .borderRadius(r = 20.px)
            .backgroundColor(Colors.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SocialMediaLink.values().forEach {
            SocialLink(it)
        }
    }
}

private enum class SocialMediaLink(
    val path: String,
    val iconName: String
) {
    Facebook(
        Constants.SocialMediaLinks.FACEBOOK,
        "facebook"
    ),
    Twitter(
        Constants.SocialMediaLinks.TWITTER,
        "twitter"
    ),
    Instagram(
        Constants.SocialMediaLinks.INSTAGRAM,
        "instagram"
    ),
    Linkedin(
        Constants.SocialMediaLinks.LINKEDIN,
        "linkedin"
    )
}

val SocialLinkItemStyle by ComponentStyle {
    base {
        Modifier.color(Theme.Gray.rgb)
            .transition(CSSTransition(
                property = "color",
                duration = 200.ms
            ))
    }
    hover {
        Modifier.color(Theme.Primary.rgb)
    }
}

@Composable
private fun SocialLink(socialMediaLink: SocialMediaLink) {
    Link(
        path = socialMediaLink.path,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaIcon(
            modifier = SocialLinkItemStyle.toModifier()
                .margin(bottom = 40.px),
            size = IconSize.LG,
            style = IconCategory.BRAND,
            name = socialMediaLink.iconName,
        )
    }
}