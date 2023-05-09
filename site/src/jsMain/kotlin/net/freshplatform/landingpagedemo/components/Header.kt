package net.freshplatform.landingpagedemo.components

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
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.FaIcon
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayBetween
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIf
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import net.freshplatform.landingpagedemo.models.Section
import net.freshplatform.landingpagedemo.models.Theme
import net.freshplatform.landingpagedemo.utils.Res
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Nav

val NavigationItemStyle by ComponentStyle {
    base {
        Modifier.color(Theme.Secondary.rgb)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    anyLink {
        Modifier.color(Theme.Secondary.rgb)
    }
    hover {
        Modifier.color(Theme.Primary.rgb)
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
        name = if (menuOpened) "caret-down" else "bars"
    )
    Row(
        modifier = Modifier.displayIf(Breakpoint.LG).then(modifier).fillMaxWidth()
            .borderRadius(r = 50.px)
            .backgroundColor(Theme.LighterGray.rgb)
            .padding(16.px),
        horizontalArrangement = Arrangement.End
    ) {
        Section.values().take(Section.SECTION_TO_TAKE).forEach { section ->
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