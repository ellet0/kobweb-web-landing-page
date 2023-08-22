package com.ahmedhnewa.landingpagedemo.sections.contact.components

import androidx.compose.runtime.*
import com.ahmedhnewa.landingpagedemo.models.Theme
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Form
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextInput

@Composable
fun ContactForm() = Form(
    action = "",
) {
    val breakpoint = rememberBreakpoint()

    Column {
        MyTextInput(
            id = "nameInput",
            hintText = "Full Name",
            labelText = "Name",
            type = InputType.Text,
            breakpoint = breakpoint,
            modifier = Modifier.margin(bottom = 12.px)
        )
        MyTextInput(
            id = "emailInput",
            hintText = "Email Address",
            labelText = "Email",
            type = InputType.Email,
            breakpoint = breakpoint,
            modifier = Modifier.margin(bottom = 12.px)
        )
        MyTextInput(
            id = "messageInput",
            hintText = "Your message",
            labelText = "Message",
            textArea = true,
            breakpoint = breakpoint,
            modifier = Modifier.margin(bottom = 20.px)
                .height(150.px)
        )
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            MyButton(
                labelText = "Submit"
            )
        }
    }
}