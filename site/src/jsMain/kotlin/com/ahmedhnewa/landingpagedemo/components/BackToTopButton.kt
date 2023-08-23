package com.ahmedhnewa.landingpagedemo.components

import androidx.compose.runtime.*
import com.ahmedhnewa.landingpagedemo.models.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowUp
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.w3c.dom.SMOOTH
import org.w3c.dom.ScrollBehavior
import org.w3c.dom.ScrollToOptions

val BackToTopButtonStyle by ComponentStyle {
    base {
        Modifier.rotate(a = 180.deg)
            .backgroundColor(Theme.Primary.rgb)
            .transition(
                CSSTransition(property = "rotate", duration = 200.ms),
                CSSTransition(property = "background-color", duration = 150.ms)
            )
    }
    hover {
        Modifier.rotate(a = 0.deg)
            .backgroundColor(Theme.Secondary.rgb)
    }
}

@Composable
fun BackToTopButton() {
    val breakpoint = rememberBreakpoint()
    var scrollTop: Double? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit) {
        window.addEventListener(type = "scroll", callback = {
            scrollTop = document.documentElement?.scrollTop ?: 0.0
        })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .position(Position.Fixed)
            .zIndex(1)
            .styleModifier {
                property("pointer-events", "none")
            },
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        scrollTop?.let { scrollTop ->
            Box(
                modifier = BackToTopButtonStyle
                    .toModifier()
                    .size(50.px)
                    .visibility(
                        if (scrollTop > 400) Visibility.Visible
                        else Visibility.Hidden
                    )
                    .margin(
                        right = if (breakpoint <= Breakpoint.SM) 30.px else 40.px,
                        bottom = if (breakpoint <= Breakpoint.SM) 30.px else 40.px
                    )
                    .borderRadius(20.percent)
                    .cursor(Cursor.Pointer)
                    .onClick {
                        window.scrollTo(
                            options = ScrollToOptions(
                                top = 0.0,
                                behavior = ScrollBehavior.SMOOTH
                            )
                        )
                    }
                    .styleModifier {
                        property("pointer-events", "auto")
                    },
                contentAlignment = Alignment.Center
            ) {
                FaArrowUp(
                    modifier = Modifier.color(Colors.White),
                    size = IconSize.LG
                )
            }
        }
    }
}