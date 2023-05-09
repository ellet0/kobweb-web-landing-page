package net.freshplatform.landingpagedemo.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.theme.SilkTheme
import net.freshplatform.landingpagedemo.components.Header
import net.freshplatform.landingpagedemo.models.Theme
import net.freshplatform.landingpagedemo.utils.Constants
import net.freshplatform.landingpagedemo.utils.Res
import org.jetbrains.compose.web.css.px


@Composable
fun MainSection() {
    Box(
        modifier = Modifier.height(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        MainBackground()
        Header()
    }
}

@Composable
private fun MainBackground() {
    Image(
        modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Cover),
        src = Res.Assets.Svg.BACKGROUND,
        desc = "Background Image For Main Section",
    )
}