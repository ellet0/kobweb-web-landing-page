package com.ahmedhnewa.landingpagedemo.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
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
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIf
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.ahmedhnewa.landingpagedemo.models.Section
import com.ahmedhnewa.landingpagedemo.models.Theme
import com.ahmedhnewa.landingpagedemo.utils.constants.Res
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
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

@Composable
fun Header() {
    val content: @Composable () -> Unit = {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            StartSide()
            EndSide()
        }
    }
    val margin = Modifier.margin(topBottom = 50.px)
    Nav(
        attrs = Modifier.displayIf(Breakpoint.LG).fillMaxWidth(80.percent)
            .then(margin)
            .toAttrs()
    ) {
        content()
    }
    Nav(
        attrs = Modifier.displayBetween(Breakpoint.SM, Breakpoint.LG).fillMaxWidth(90.percent)
            .then(margin)
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
private fun EndSide(modifier: Modifier = Modifier) {
    var menuOpened by remember { mutableStateOf(false) }
    FaIcon(
        modifier = Modifier.color(Theme.Secondary.rgb)
            .displayUntil(Breakpoint.LG)
            .margin(right = 15.px)
            .onClick { menuOpened = !menuOpened },
        size = IconSize.XL,
        name = if (menuOpened) "caret-down" else "bars",
        style = IconCategory.SOLID
    )
    Row(
        modifier = Modifier.displayIf(Breakpoint.LG).then(modifier).fillMaxWidth()
            .borderRadius(r = 50.px)
            .backgroundColor(Theme.LighterGray.rgb)
            .padding(16.px),
        horizontalArrangement = Arrangement.End
    ) {
        Section.navigationItems.forEach { section ->
            Link(
                path = section.path,
                text = section.title,
                modifier = NavigationItemStyle.toModifier()
                    .padding(right = 30.px)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .textDecorationLine(TextDecorationLine.None),
            )
        }
    }
}