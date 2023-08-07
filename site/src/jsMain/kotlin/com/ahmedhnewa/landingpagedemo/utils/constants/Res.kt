package com.ahmedhnewa.landingpagedemo.utils.constants

object Res {
    object Assets {
        private const val PATH = "/assets"

        object Images {
            private const val PATH = "${Assets.PATH}/images"
            const val MAIN = "$PATH/main_image.png"
            const val ABOUT = "$PATH/about_image.png"
        }

        object Svg {
            private const val PATH = "${Assets.PATH}/svg"
            const val LOGO = "$PATH/logo.svg"
            const val BACKGROUND = "$PATH/background.svg"
        }
    }
}