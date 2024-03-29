package com.ahmedhnewa.landingpagedemo.sections.products.components

import androidx.compose.runtime.Composable
import com.ahmedhnewa.landingpagedemo.components.stars.RatingBar
import com.ahmedhnewa.landingpagedemo.models.Theme
import com.ahmedhnewa.landingpagedemo.sections.main.MainImageStyle
import com.ahmedhnewa.landingpagedemo.sections.products.models.Product
import com.ahmedhnewa.landingpagedemo.utils.constants.Constants
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.grayscale
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

val ProductImageStyle by ComponentStyle {
    base {
        Modifier
            .filter(grayscale(0.percent))
            .transition(CSSTransition(property = "filter", duration = 240.ms))
    }
    hover {
        Modifier
            .filter(grayscale(100.percent))
    }

}

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: Product
) {
    Column(
        modifier = Modifier
            .margin(all = 6.px)
            .padding(leftRight = 12.px, topBottom = 16.px)
            .width(300.px)
            .then(modifier)
    ) {
        Image(
            modifier = ProductImageStyle
                .toModifier()
                .height(250.px)
                .fillMaxWidth()
                .borderRadius(r = 8.px)
                .objectFit(ObjectFit.Cover)
                .attrsModifier {
                    attr("loading", "lazy")
                },
            src = product.image,
            desc = "${product.productName} image",
        )
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 7.px, bottom = 2.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(13.px)
                .fontWeight(FontWeight.Bold)
                .textAlign(TextAlign.Center)
                .toAttrs()
        ) {
            Text(product.company)
        }
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(topBottom = 0.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Normal)
                .textAlign(TextAlign.Center)
                .toAttrs()
        ) {
            Text(product.productName)
        }
        Box(
            modifier = Modifier
                .margin(topBottom = 5.px)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            RatingBar()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .margin(right = 5.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .textAlign(TextAlign.Center)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("$${product.originalPrice}")
            }
            if (product.originalPrice > product.discountPrice && product.discountPrice != 0.0) {
                P(
                    attrs = Modifier
                        .margin(topBottom = 0.px)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(16.px)
                        .fontWeight(FontWeight.Normal)
                        .textDecorationLine(TextDecorationLine.LineThrough)
                        .color(Theme.Secondary.rgb)
                        .toAttrs()
                ) {
                    Text("$${product.discountPrice}")
                }
            }
        }
    }
}