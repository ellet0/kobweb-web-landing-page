package net.freshplatform.landingpagedemo.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.VerticalAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.icons.fa.FaIdCard
import net.freshplatform.landingpagedemo.models.SECTION_TO_TAKE
import net.freshplatform.landingpagedemo.models.Section
import net.freshplatform.landingpagedemo.sections.MainSection
import net.freshplatform.landingpagedemo.utils.Constants
import org.jetbrains.compose.web.css.AlignContent
import org.jetbrains.compose.web.css.CSSRuleDeclaration
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Style
import org.jetbrains.compose.web.dom.Text

@Page
@Composable
fun HomePage() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Section.values().take(SECTION_TO_TAKE).forEach {
            Section(Modifier.id(it.id).toAttrs()) {
                it.content()
            }
        }
    }
}
