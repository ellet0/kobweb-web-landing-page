package net.freshplatform.landingpagedemo.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIf
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import net.freshplatform.landingpagedemo.models.SECTION_TO_TAKE
import net.freshplatform.landingpagedemo.models.Section
import net.freshplatform.landingpagedemo.models.Theme
import net.freshplatform.landingpagedemo.utils.Res
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
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
    val breakpoint by rememberBreakpoint()
    LaunchedEffect(breakpoint) {}
    Nav(Modifier.fillMaxWidth(80.percent).margin(topBottom = 50.px).toAttrs()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            StartSide()
            EndSide(modifier = Modifier.displayIf(Breakpoint.MD))
        }
    }
}

@Composable
private fun StartSide(modifier: Modifier = Modifier) {
    Row(modifier = Modifier.then(modifier)) {
        Image(
            modifier = BrandingLogoStyle.toModifier(),
            src = Res.Assets.Svg.LOGO,
            desc = "Logo"
        )
    }
}

@Composable
private fun EndSide(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.then(modifier).fillMaxWidth()
            .borderRadius(r = 50.px)
            .backgroundColor(Theme.LighterGray.rgb)
            .padding(16.px),
        horizontalArrangement = Arrangement.End
    ) {
        Section.values().take(SECTION_TO_TAKE).forEach { section ->
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