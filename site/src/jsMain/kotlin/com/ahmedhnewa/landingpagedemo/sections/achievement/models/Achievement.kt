package com.ahmedhnewa.landingpagedemo.sections.achievement.models

import androidx.compose.runtime.mutableStateListOf

enum class Achievement(
    val icon: String,
    val number: Int,
    val description: String
) {
    Completed(
        icon = "square-check",
        number = 20,
        description = "Completed Projects"
    ),
    Active(
        icon = "circle-dot",
        number = 3,
        description = "Active Projects"
    ),
    Satisfied(
        icon = "face-smile",
        number = 6,
        description = "Satisfied Clients"
    ),
    Team(
        icon = "user",
        number = 1,
        description = "Team Members"
    );
    companion object {
        // should match the length of enum items
        val animationDefaultValues = mutableStateListOf(0, 0, 0, 0)
    }
}