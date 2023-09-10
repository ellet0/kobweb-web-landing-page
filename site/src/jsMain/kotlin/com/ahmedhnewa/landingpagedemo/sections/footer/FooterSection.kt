package com.ahmedhnewa.landingpagedemo.sections.footer

import androidx.compose.runtime.Composable
import com.ahmedhnewa.landingpagedemo.sections.main.compoments.NavigationLinks
import com.ahmedhnewa.landingpagedemo.models.Theme
import com.ahmedhnewa.landingpagedemo.sections.main.compoments.SocialBar
import com.ahmedhnewa.landingpagedemo.utils.constants.Constants
import com.ahmedhnewa.landingpagedemo.utils.constants.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun FooterSection() = Box(
    modifier = Modifier
        .padding(topBottom = 100.px)
        .backgroundColor(Theme.LighterGray.rgb),
    contentAlignment = Alignment.Center
) {
    FooterContent()
}

@Composable
private fun FooterContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(100.px)
                .attrsModifier {
                    attr("loading", "lazy")
                },
            src = Res.Assets.Svg.LOGO,
            desc = "Logo Image"
        )
        Box(
            modifier = Modifier.fillMaxWidth()
                .backgroundColor(Theme.LighterGray.rgb)
                .padding(16.px)
                .margin(bottom = 16.px),
            contentAlignment = Alignment.Center
        ) {
            Row(modifier = Modifier.displayIfAtLeast(Breakpoint.MD)) {
                NavigationLinks(
                    eachItemModifier = Modifier
                        .padding(right = 20.px)
                        .fontSize(16.px)
                )
            }
            Column(modifier = Modifier.displayUntil(Breakpoint.MD)) {
                NavigationLinks(
                    eachItemModifier = Modifier
                        .padding(topBottom = 8.px, leftRight = 0.px)
                        .fontSize(16.px)
                        .fillMaxWidth()
                        .textAlign(TextAlign.Center)
                )
            }
        }
        SocialBar(
            modifier = Modifier.margin(bottom = 20.px),
            isRow = true
        )
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(topBottom = 0.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Bold)
                .textAlign(TextAlign.Center)
                .toAttrs()
        ) {
            Text("Copyright 2023")
        }
    }
}