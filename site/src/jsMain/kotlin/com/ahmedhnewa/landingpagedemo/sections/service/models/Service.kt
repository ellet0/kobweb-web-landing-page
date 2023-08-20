package com.ahmedhnewa.landingpagedemo.sections.service.models

import com.varabyte.kobweb.silk.components.icons.fa.IconCategory

enum class Service(
    val icon: String,
    val iconDesc: String,
    val iconCategory: IconCategory,
    val title: String,
    val description: String
) {
    Android(
        "android",
        "Android Icon",
        IconCategory.BRAND,
        "Android Development",
        "Do you want someone to build native android app with the latest technology by google using kotlin and jetpack compose and latest principles? you come to one of the right places."
    ),
    iOS(
        "app-store-ios",
        "iOS Icon",
        IconCategory.BRAND,
        "iOS Development",
        "If you want native iOS app using swift and swift ui and follow apple guidelines, then I can do it."
    ),
    Web(
        "firefox-browser",
        "Web Icon",
        IconCategory.BRAND,
        "Web development",
        "Do you want a simple website like this one?? from scratch without using prebuilt website makers like wordpress etc..."
    ),
    GameDevelopment(
        "gamepad",
        "Game Development Icon",
        IconCategory.SOLID,
        "Game Development",
        "Do you want to publish some games?? with unreal engine 5 with blueprint and c++?? it's easy for simple games"
    ),
    BackendDevelopment(
        "server",
        "Backend Development Icon",
        IconCategory.SOLID,
        "Backend Development",
        "I can build a backend for your app, I already built many using ktor server, node js with express"
    ),
    ServerSetup(
        "linux",
        "Server Development Icon",
        IconCategory.BRAND,
        "Server Setup",
        "Did I mention I'm linux fanboy?? Fedora, Ubuntu, Mint, Manjaro, Debian and more distros and desktop environments that I'm already familiar with, I can setup linux server, even microsoft use linux as server os for their download page for windows"
    );
}