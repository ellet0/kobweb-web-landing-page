package com.ahmedhnewa.landingpagedemo.components.stars

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.silk.components.icons.fa.*
import org.jetbrains.compose.web.css.Color

private const val YELLOW_COLOR_HEX = "#FFD700"

@Composable
fun StarIcon(
    modifier: Modifier = Modifier,
    size: IconSize? = null,
    style: IconStyle? = null,
    halfStar: Boolean = false
) {
    if (halfStar) {
        FaStarHalfStroke(
            modifier = Modifier.color(
                Color(YELLOW_COLOR_HEX)
            ).then(modifier),
            size = size,
            style = style ?: IconStyle.OUTLINE
        )
        return
    }
    FaStar(
        modifier = Modifier.color(
            Color(YELLOW_COLOR_HEX)
        ).then(modifier),
        size = size,
        style = style ?: IconStyle.FILLED
    )
}
