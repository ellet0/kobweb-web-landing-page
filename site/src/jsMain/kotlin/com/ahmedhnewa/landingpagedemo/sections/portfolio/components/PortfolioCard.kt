package com.ahmedhnewa.landingpagedemo.sections.portfolio.components

import androidx.compose.runtime.*
import com.ahmedhnewa.landingpagedemo.models.Theme
import com.ahmedhnewa.landingpagedemo.sections.portfolio.PortfolioSectionStyle
import com.ahmedhnewa.landingpagedemo.sections.portfolio.models.Portfolio
import com.ahmedhnewa.landingpagedemo.utils.constants.Constants
import com.ahmedhnewa.landingpagedemo.utils.extensions.maximumAtFirst
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowUpRightFromSquare
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

const val PORTFOLIO_CARD_HEIGHT = 300

@Composable
fun PortfolioCard(
    modifier: Modifier = Modifier,
    portfolio: Portfolio,
) {
    Link(
        modifier = PortfolioSectionStyle.toModifier()
            .textDecorationLine(TextDecorationLine.None)
            .userSelect(UserSelect.None),
        path = portfolio.link,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        Column(
            modifier = Modifier
                .id("columnParent")
                .then(modifier)
        ) {
            ImageBox(portfolio = portfolio)
            P(
                attrs = Modifier
                    .id("portfolioTitle")
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
            ) {
                Text(portfolio.title)
            }
            P(
                attrs = Modifier
                    .id("portfolioDesc")
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .opacity(50.percent)
                    .onClick {
                        window.alert(portfolio.description)
                    }
                    .toAttrs()
            ) {
                Text(portfolio.description.maximumAtFirst(100))
            }
        }
    }
}

@Composable
private fun ImageBox(portfolio: Portfolio) {
    Box(
        modifier = Modifier
            .id("imageBox")
            .margin(bottom = 20.px)
            .fillMaxWidth()
            .width(PORTFOLIO_CARD_HEIGHT.px)
    ) {
        val imageBorderRadius = 4.px
        Image(
            modifier = Modifier
                .borderRadius(r = imageBorderRadius)
                .size(PORTFOLIO_CARD_HEIGHT.px)
                .objectFit(ObjectFit.Cover)
                .attrsModifier {
                    attr("loading", "lazy")
                },
            src = portfolio.image,
            desc = portfolio.title
        )
        Box(
            modifier = Modifier
                .id("greenOverlay")
                .borderRadius(r = imageBorderRadius)
                .height(PORTFOLIO_CARD_HEIGHT.px)
                .backgroundColor(Color.Companion.argb(a = 0.5f, r = 0, g = 167, b = 142)),
            contentAlignment = Alignment.Center,
        ) {
            FaArrowUpRightFromSquare(
                modifier = Modifier
                    .id("linkIcon")
                    .title("Link icon")
                    .color(Colors.White)
                    .attrsModifier {
                        attr("alt", "Link icon")
                    },
                size = IconSize.X2
            )
        }
    }
}