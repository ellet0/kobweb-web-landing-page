package com.ahmedhnewa.landingpagedemo.sections.about.compoments

import androidx.compose.runtime.Composable
import com.ahmedhnewa.landingpagedemo.components.ParagraphText
import com.ahmedhnewa.landingpagedemo.models.Theme
import com.ahmedhnewa.landingpagedemo.utils.constants.Constants
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SkillBar(
    name: String,
    percentageValue: CSSLengthOrPercentageValue = 50.percent,
    progressBarHeight: CSSSizeValue<CSSUnit.px> = 5.px
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .margin(bottom = 10.px)
            .maxWidth(500.px)
            .padding(topBottom = 5.px)
    ) {
        Row(
            modifier = Modifier
                .margin(bottom = 5.px)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ParagraphText(
                name,
                modifier = Modifier.margin(topBottom = 2.px)
            )
            ParagraphText(
                "${percentageValue.value.toInt()}${percentageValue.unit}",
                modifier = Modifier.margin(topBottom = 2.px),
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .height(progressBarHeight)
                    .backgroundColor(Theme.LightGray.rgb)
            )
            Box(
                modifier = Modifier.fillMaxWidth(percentageValue.value.percent)
                    .height(progressBarHeight)
                    .backgroundColor(Theme.Primary.rgb)
            )
        }
    }
}