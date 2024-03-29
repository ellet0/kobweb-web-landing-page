package com.ahmedhnewa.landingpagedemo.sections.location

import androidx.compose.runtime.Composable
import com.ahmedhnewa.landingpagedemo.components.SectionTitle
import com.ahmedhnewa.landingpagedemo.models.Section
import com.ahmedhnewa.landingpagedemo.utils.constants.SectionsConstants
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Iframe

@Composable
fun LocationSection() = Box(
    modifier = Modifier
        .padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    LocationContent()
}

@Composable
private fun LocationContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth(
                    if (breakpoint > Breakpoint.LG) 55.percent
                    else if (breakpoint >= Breakpoint.MD) 70.percent
                    else 100.percent
                )
                .margin(bottom = 40.px),
            section = Section.Location,
            alignment = Alignment.Start
        )
        Iframe(
            attrs = Modifier
                .fillMaxWidth(
                    if (breakpoint > Breakpoint.LG) 55.percent
                    else if (breakpoint >= Breakpoint.MD) 70.percent
                    else 100.percent
                )
                .minHeight(800.px)
                .border {
                    style(LineStyle.None)
                }
                .toAttrs {
                    attr("loading", "lazy")
                    attr("allowfullscreen", "")
                    attr("referrerpolicy", "no-referrer-when-downgrade")
                    attr(
                        "src",
                        SectionsConstants.Location.MAP_API
                    )
                },
        )
    }
}
