package net.freshplatform.landingpagedemo.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import net.freshplatform.landingpagedemo.models.Section
import org.jetbrains.compose.web.dom.Section

@Page
@Composable
fun HomePage() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Section.values().take(Section.SECTION_TO_TAKE).forEach {
            Section(Modifier.id(it.id).toAttrs()) {
                it.content()
            }
        }
    }
}
