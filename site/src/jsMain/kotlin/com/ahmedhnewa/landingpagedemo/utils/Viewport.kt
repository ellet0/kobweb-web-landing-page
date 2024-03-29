package com.ahmedhnewa.landingpagedemo.utils

import androidx.compose.runtime.*
import com.ahmedhnewa.landingpagedemo.utils.constants.Constants
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.events.EventListener

@Composable
fun ObserveViewportEntered(
    sectionId: String,
    distanceFromTop: Double,
    onViewportEntered: () -> Unit
) {
    var viewportEntered by remember { mutableStateOf(false) }
    val listener = remember {
        EventListener {
            val sectionElement =
                document.getElementById(sectionId)
                    ?: throw NullPointerException("Can't find any element with id = $sectionId")
            val top = sectionElement.getBoundingClientRect().top
            if (top < distanceFromTop) {
                viewportEntered = true
            }
        }
    }

    LaunchedEffect(viewportEntered) {
        if (!viewportEntered) {
            window.addEventListener(type = "scroll", callback = listener)
            return@LaunchedEffect
        }
        onViewportEntered()
        window.removeEventListener(type = "scroll", callback = listener)
    }

}