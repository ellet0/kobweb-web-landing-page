package com.ahmedhnewa.landingpagedemo.models

import com.ahmedhnewa.landingpagedemo.utils.constants.Constants

enum class SocialMediaLink(
    val path: String,
    val iconName: String
) {
    Facebook(
        Constants.SocialMediaLinks.FACEBOOK,
        "facebook"
    ),
    Twitter(
        Constants.SocialMediaLinks.TWITTER,
        "twitter"
    ),
    Instagram(
        Constants.SocialMediaLinks.INSTAGRAM,
        "instagram"
    ),
    Linkedin(
        Constants.SocialMediaLinks.LINKEDIN,
        "linkedin"
    )
}