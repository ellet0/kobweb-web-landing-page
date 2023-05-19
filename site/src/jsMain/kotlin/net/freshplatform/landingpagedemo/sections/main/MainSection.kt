package net.freshplatform.landingpagedemo.sections.main

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayBetween
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIf
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import net.freshplatform.landingpagedemo.components.Header
import net.freshplatform.landingpagedemo.models.Section
import net.freshplatform.landingpagedemo.models.Theme
import net.freshplatform.landingpagedemo.sections.main.compoments.SocialBar
import net.freshplatform.landingpagedemo.utils.constants.Constants
import net.freshplatform.landingpagedemo.utils.constants.Res
import net.freshplatform.landingpagedemo.utils.extensions.removeCharAtIndex
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun MainSection() {
    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        MainBackground()
        MainContent()
    }
}

@Composable
private fun MainBackground() {
    Image(
        modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Cover),
        src = Res.Assets.Svg.BACKGROUND,
        desc = "Background Image For Main Section",
    )
}

@Composable
private fun MainContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween, // Not necessary
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header() // fill max width (80 to 90 percent)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val content: @Composable () -> Unit = {
                MainText()
                MainImage()
            }
            val numColumns = numColumns(base = 1, md = 2)
            SimpleGrid(
                modifier = Modifier.displayIf(Breakpoint.LG).fillMaxWidth(80.percent),
                numColumns = numColumns
            ) {
                content()
            }
            SimpleGrid(
                modifier = Modifier.displayBetween(Breakpoint.SM, Breakpoint.LG).fillMaxWidth(90.percent),
                numColumns = numColumns
            ) {
                content()
            }
        }
    }
}

@OptIn(ExperimentalComposeWebApi::class)
val helloImTextStyle by ComponentStyle {
    base {
        Modifier.scale(1.0)
            .margin(topBottom = 0.px)
            .fontSize(45.px)
            .fontWeight(FontWeight.Normal)
            .color(Theme.Primary.rgb)
            .transition(CSSTransition(property = "scale", duration = 300.ms))
            .transition(CSSTransition(property = "transform", duration = 200.ms))
            .transform { rotate(0.deg) }
    }
    hover {
        Modifier.scale(1.2)
            .transform { rotate((3).deg) }
    }
}

val MainButtonStyle by ComponentStyle {
    base {
        Modifier.width(100.px)
            .transition(CSSTransition(property = "width", duration = 200.ms))
    }
    hover {
        Modifier.width(120.px)
    }

}

@Composable
private fun MainText() {
    var helloImText by remember { mutableStateOf("Hello, I'm") }
    @Composable
    fun AnimateHelloImText() {
        var isPlusOperator = true
        LaunchedEffect(true) {
            val value = helloImText
            helloImText = ""

            while (true) {
                for (charIndex in value.indices) {
                    if (isPlusOperator) {
                        helloImText += value[charIndex]
                        delay(200L)
                        continue
                    }
                    if (helloImText[helloImText.lastIndex] == 'H') {
                        isPlusOperator = !isPlusOperator
                        continue
                    }
                    helloImText = helloImText.removeCharAtIndex(helloImText.lastIndex)
                    delay(100L)
                }
                isPlusOperator = !isPlusOperator
            }
        }
    }
    if (Constants.ANIMATION_ENABLED) {
        AnimateHelloImText()
    }
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SocialBar(modifier = Modifier.displayIf(Breakpoint.LG))
        Column {
            P(
                attrs = helloImTextStyle.toAttrs()
            ) {
                Text(helloImText)
            }
            P(
                attrs = Modifier
                    .displayIf(Breakpoint.LG)
                    .margin(top = 20.px, bottom = 0.px)
                    .fontSize(68.px)
                    .fontWeight(FontWeight.Bolder)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(Constants.Data.DEVELOPER_NAME)
            }
            P(
                attrs = Modifier
                    .displayBetween(Breakpoint.SM, Breakpoint.LG)
                    .margin(top = 20.px, bottom = 0.px)
                    .fontSize(40.px)
                    .fontWeight(FontWeight.Bolder)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(Constants.Data.DEVELOPER_NAME)
            }
            P(
                attrs = Modifier
                    .margin(top = 10.px, bottom = 5.px)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(Constants.Data.JOB_TITLE)
            }
            P(
                attrs = Modifier
                    .margin(bottom = 5.px)
                    .maxWidth(400.px)
                    .fontSize(15.px)
                    .fontStyle(FontStyle.Italic)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(Constants.Data.WHO_IAM)
            }
            Button(
                attrs = MainButtonStyle.toModifier()
                    .margin(bottom = 20.px, top = 10.px)
                    .height(40.px)
                    .border(width = 0.px)
                    .borderRadius(5.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(Colors.White)
                    .cursor(Cursor.Pointer)
                    .toAttrs()
            ) {
                Link(
                    modifier = Modifier
                        .color(Colors.White)
                        .textDecorationLine(TextDecorationLine.None),
                    path = Section.Contact.path,
                    openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
                    text = "Hire me",
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeWebApi::class)
val MainImageStyle by ComponentStyle {
    base {
        Modifier
            .styleModifier {
                filter { grayscale(100.percent) }
            }
            .transition(CSSTransition(property = "filter", duration = 200.ms))
    }
    hover {
        Modifier
            .styleModifier {
                filter { grayscale(0.percent) }
            }
    }

}

@Composable
fun MainImage() {
    println(Res.Assets.Images.MAIN_IMAGE)
    Column(
        modifier = MainImageStyle.toModifier()
            .fillMaxSize(80.percent).fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            modifier = Modifier.fillMaxWidth().objectFit(ObjectFit.Cover),
            src = Res.Assets.Images.MAIN_IMAGE,
            desc = "Developer photo"
        )
    }
}