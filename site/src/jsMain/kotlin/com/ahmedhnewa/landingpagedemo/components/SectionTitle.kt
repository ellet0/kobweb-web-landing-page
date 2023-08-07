package com.ahmedhnewa.landingpagedemo.components

import androidx.compose.runtime.Composable
import com.ahmedhnewa.landingpagedemo.models.Section
import com.ahmedhnewa.landingpagedemo.models.Theme
import com.ahmedhnewa.landingpagedemo.utils.constants.Constants
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    section: Section,
    alignment: Alignment.Horizontal = Alignment.Start
) {
    val textAlign = when (alignment) {
        Alignment.CenterHorizontally -> TextAlign.Center
        Alignment.End -> TextAlign.End
        else -> TextAlign.Start
    }
    Column(modifier = modifier, horizontalAlignment = alignment) {
        ParagraphText(
            section.title,
            modifier = Modifier.fillMaxWidth()
                .textAlign(
                    textAlign
                )
                .margin(topBottom = 0.px),
            fontSize = 25.px,
            color = Theme.Primary.rgb
        )
        ParagraphText(
            section.subtitle,
            modifier = Modifier.fillMaxWidth()
                .textAlign(
                    textAlign
                )
                .margin(bottom = 10.px, top = 0.px)
                .fontWeight(FontWeight.Bold),
            fontSize = 40.px,
        )
        Box(
            modifier = Modifier.height(2.px)
                .width(80.px)
                .backgroundColor(Theme.Primary.rgb)
                .borderRadius(r = 50.px)
        )
    }
}

@Composable
fun ParagraphText(
    value: String,
    modifier: Modifier = Modifier,
    fontSize: CSSNumeric = 18.px,
    color: CSSColorValue = Theme.Secondary.rgb,
) {
    P(
        attrs = Modifier
            .fontFamily(Constants.FONT_FAMILY)
            .fontSize(fontSize)
            .fontWeight(FontWeight.Normal)
            .color(color)
            .then(modifier)
            .toAttrs()
    ) {
        Text(value)
    }
}