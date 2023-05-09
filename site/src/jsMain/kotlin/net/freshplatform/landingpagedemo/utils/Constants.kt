package net.freshplatform.landingpagedemo.utils

object Constants {
    const val SECTION_WIDTH = 1920
    // Also in build.gradle
    const val FONT_FAMILY = "roboto"
}

object Res {
    object Assets {
        private const val PATH = "/assets"
        object Svg {
            private const val PATH = "${Assets.PATH}/svg"
            const val BACKGROUND = "$PATH/background.svg"
            const val LOGO = "$PATH/logo.svg"
        }
    }
}