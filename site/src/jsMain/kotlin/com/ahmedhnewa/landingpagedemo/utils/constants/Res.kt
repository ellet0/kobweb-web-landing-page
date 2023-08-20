package com.ahmedhnewa.landingpagedemo.utils.constants

object Res {
    object Assets {
        private const val PATH = "/assets"

        object Images {
            private const val PATH = "${Assets.PATH}/images"
            const val MAIN = "$PATH/main_image.png"
            const val ABOUT = "$PATH/about_image.png"
            const val FRESH_PLATFORM = "$PATH/fresh_platform.png"
            const val DR_RIADH_LAB = "$PATH/dr_riadh_lab.png"
            const val ALRAYADA_PROJECT = "$PATH/alrayada_project.png"
            const val WALLPAPER_ENGINE = "$PATH/wallpaper_engine.jpg"
            const val AHMED_HNEWA_SOCIAL_MEDIA = "$PATH/ahmedhnewa_social_media.png"
        }

        object Svg {
            private const val PATH = "${Assets.PATH}/svg"
            const val LOGO = "$PATH/logo.svg"
            const val BACKGROUND = "$PATH/background.svg"
        }
    }
}