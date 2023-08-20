package com.ahmedhnewa.landingpagedemo.sections.portfolio

import androidx.compose.runtime.Composable
import com.ahmedhnewa.landingpagedemo.components.SectionTitle
import com.ahmedhnewa.landingpagedemo.models.Section
import com.ahmedhnewa.landingpagedemo.sections.portfolio.components.PORTFOLIO_CARD_HEIGHT
import com.ahmedhnewa.landingpagedemo.sections.portfolio.components.PortfolioCard
import com.ahmedhnewa.landingpagedemo.sections.portfolio.models.Portfolio
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.w3c.dom.Element

@Composable
fun PortfolioSection() = Box(
    modifier = Modifier.padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    PortfolioContent()
}

@Composable
private fun PortfolioContent() {
    // Could be optimized
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            SectionTitle(
                modifier = Modifier.fillMaxWidth()
                    .margin(bottom = 25.px),
                section = Section.Portfolio,
            )
            PortfolioCards(
                modifier = Modifier.margin(bottom = 25.px),
                breakpoint = breakpoint
            )
            PortfolioNavigation()
        }
    }
}

@Composable
private fun PortfolioCards(modifier: Modifier = Modifier, breakpoint: Breakpoint) {
    Row(
        modifier = Modifier
            .id("scrollablePortfolioCards")
            .fillMaxWidth()
            .maxWidth(
                if (breakpoint > Breakpoint.MD) 950.px // for three cards with margins
                else if (breakpoint > Breakpoint.SM) 625.px // for two cards with margins
                else PORTFOLIO_CARD_HEIGHT.px // for one
            )
            .overflow(Overflow.Hidden)
            .scrollBehavior(ScrollBehavior.Smooth)
            .then(modifier)
    ) {
        val portfolios = Portfolio.values()
        portfolios.forEach { portfolio ->
            val isLast = portfolio == portfolios.last()
            PortfolioCard(
                modifier = Modifier.margin(right = if (isLast) 0.px else 25.px),
                portfolio = portfolio
            )
        }
    }
}

@Composable
private fun PortfolioNavigation() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        val scrollableContainerId = "scrollablePortfolioCards"
        fun scrollableContainer(): Element {
            return document.getElementById(scrollableContainerId)
                ?: throw NullPointerException("Can't find element with id = $scrollableContainerId")
        }
        FaArrowLeft(
            modifier = PortfolioArrowIconStyle.toModifier()
                .margin(right = 40.px)
                .cursor(Cursor.Pointer)
                .onClick { scrollableContainer().scrollBy(x = (-325.0), y = 0.0) }
        )
        FaArrowRight(
            modifier = PortfolioArrowIconStyle.toModifier()
                .cursor(Cursor.Pointer)
                .onClick { scrollableContainer().scrollBy(x = 325.0, y = 0.0) }
        )
    }
}