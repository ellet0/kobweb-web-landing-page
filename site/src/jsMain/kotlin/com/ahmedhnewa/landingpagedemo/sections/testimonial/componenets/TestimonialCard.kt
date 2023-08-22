package com.ahmedhnewa.landingpagedemo.sections.testimonial.componenets

import androidx.compose.runtime.Composable
import com.ahmedhnewa.landingpagedemo.models.Theme
import com.ahmedhnewa.landingpagedemo.sections.testimonial.models.Testimonial
import com.ahmedhnewa.landingpagedemo.utils.constants.Constants
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun TestimonialCard(
    modifier: Modifier = Modifier,
    testimonial: Testimonial,
    breakpoint: Breakpoint
) {
    Row(
        modifier = Modifier.maxWidth(450.px)
            .then(modifier),
    ) {
        Image(
            modifier = Modifier
                .margin(right = 20.px)
                .height(200.px)
                .objectFit(ObjectFit.Cover)
                .width(
                    if (breakpoint > Breakpoint.MD) 180.px
                    else 160.px
                )
                .borderRadius(
                    topLeft = 60.px,
                    topRight = 60.px,
                    bottomLeft = 60.px,
                    bottomRight = 0.px
                ),
            src = testimonial.image,
            desc = "Avatar Image"
        )
        Column {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .margin(bottom = 20.px),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    P(
                        attrs = Modifier
                            .fillMaxWidth()
                            .margin(topBottom = 0.px)
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontSize(18.px)
                            .fontWeight(FontWeight.Bold)
                            .color(Theme.Secondary.rgb)
                            .toAttrs()
                    ) {
                        Text(testimonial.fullName)
                    }
                    P(
                        attrs = Modifier
                            .fillMaxWidth()
                            .margin(topBottom = 0.px)
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontSize(12.px)
                            .fontWeight(FontWeight.Normal)
                            .color(Theme.Secondary.rgb)
                            .toAttrs()
                    ) {
                        Text(testimonial.profession)
                    }
                    if (breakpoint <= Breakpoint.MD) {
                        RatingBar(
                            value = 5,
                            modifier = Modifier
                                .margin(top = 10.px)
                        )
                    }
                }
                if (breakpoint > Breakpoint.MD) {
                    RatingBar(value = 5)
                }
            }
            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(18.px)
                    .opacity(70.percent)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(testimonial.review)
            }
        }
    }
}