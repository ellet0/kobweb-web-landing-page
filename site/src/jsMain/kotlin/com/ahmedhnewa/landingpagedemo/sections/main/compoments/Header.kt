package com.ahmedhnewa.landingpagedemo.sections.main.compoments

import androidx.compose.runtime.*
import com.ahmedhnewa.landingpagedemo.models.Section
import com.ahmedhnewa.landingpagedemo.models.Theme
import com.ahmedhnewa.landingpagedemo.utils.constants.Constants
import com.ahmedhnewa.landingpagedemo.utils.constants.Res
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaIcon
import com.varabyte.kobweb.silk.components.icons.fa.IconCategory
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayBetween
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Nav

@OptIn(ExperimentalComposeWebApi::class)
val NavigationItemStyle by ComponentStyle {
    base {
        Modifier.color(Theme.Secondary.rgb)
            .transition(CSSTransition(property = "color", duration = 200.ms))
            .transition(CSSTransition(property = "transform", duration = 200.ms))
            .transition(CSSTransition(property = "scale", duration = 300.ms))
    }
    anyLink {
        Modifier.color(Theme.Secondary.rgb)
            .scale(1)
            .transform { rotate(0.deg) }
    }
    hover {
        Modifier.color(Theme.Primary.rgb)
            .scale(1.2)
            .transform { rotate((3).deg) }
    }
}

@OptIn(ExperimentalComposeWebApi::class)
val BrandingLogoStyle by ComponentStyle {
    base {
        Modifier.transition(CSSTransition(property = "transform", duration = 200.ms))
    }
    onlyChild {
        Modifier.transform {
            rotate(0.deg)
        }
    }
    hover {
        Modifier.transform { rotate((-10).deg) }
    }
}

// TODO: Add HTML 5 Header
@Composable
fun MyHeader() /*= Header(
    attrs = Modifier.fillMaxWidth().toAttrs()
) */ {
    val content: @Composable () -> Unit = {
        Row(
            modifier = Modifier.userSelect(UserSelect.None),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            StartSide()
            EndSide()
        }
    }
    val sharedModifier = Modifier
        .margin(topBottom = 50.px)
        .userSelect(UserSelect.None)
    Nav(
        attrs = Modifier.displayIfAtLeast(Breakpoint.LG).fillMaxWidth(80.percent)
            .then(sharedModifier)
            .toAttrs()
    ) {
        content()
    }
    Nav(
        attrs = Modifier.displayBetween(Breakpoint.SM, Breakpoint.LG).fillMaxWidth(90.percent)
            .then(sharedModifier)
            .toAttrs()
    ) {
        content()
    }
}

@Composable
private fun StartSide(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.then(modifier),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = BrandingLogoStyle.toModifier(),
            src = Res.Assets.Svg.LOGO,
            desc = "Logo"
        )
    }
}

@Composable
private fun EndSide(
    modifier: Modifier = Modifier,
) {
    var isMenuOpened by remember { mutableStateOf(false) }
    FaIcon(
        modifier = Modifier.color(Theme.Secondary.rgb)
            .displayUntil(Breakpoint.LG)
            .userSelect(UserSelect.None)
            .margin(right = 15.px)
            .onClick {
                isMenuOpened = !isMenuOpened

                val homeSection = document.getElementById(Section.Home.id) ?: throw NullPointerException("Can't find main section")
                val mobileNavigation = homeSection.querySelector("#mobileNavigationItems") ?: throw NullPointerException("Can't find mobileNavigationItems")
                mobileNavigation.classList.toggle("hidden")
                mobileNavigation.classList.toggle("visible")
            },
        size = IconSize.XL,
        name = if (isMenuOpened) "caret-down" else "bars",
        style = IconCategory.SOLID
    )
    Row(
        modifier = Modifier.displayIfAtLeast(Breakpoint.LG)
            .fillMaxWidth()
            .borderRadius(r = 50.px)
            .backgroundColor(Theme.LighterGray.rgb)
            .padding(16.px)
            .then(modifier),
        horizontalArrangement = Arrangement.End
    ) {
        NavigationLinks()
    }
}

@Composable
fun NavigationLinks(eachItemModifier: Modifier = Modifier) {
    Section.navigationItems.forEach { section ->
        Link(
            path = section.path,
            text = section.title,
            modifier = NavigationItemStyle
                .toModifier()
                .fontFamily(Constants.FONT_FAMILY)
                .padding(right = 30.px)
                .fontSize(18.px)
                .fontWeight(FontWeight.Normal)
                .textDecorationLine(TextDecorationLine.None)
                .then(eachItemModifier),
        )
    }
}