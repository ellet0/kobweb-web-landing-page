package com.ahmedhnewa.landingpagedemo.sections.about.models

import org.jetbrains.compose.web.css.CSSLengthOrPercentageValue
import org.jetbrains.compose.web.css.percent

enum class Skills(
    val title: String,
    val percentageValue: CSSLengthOrPercentageValue
) {
    Creative(
        "Creative",
        85.percent
    ),
    Accountable(
        "Accountable",
        87.percent
    ),
    HardWorking(
        "Hard Working",
        97.percent
    ),
    Value(
        "Value for money",
        95.percent
    ),
    Delivery(
        "On-Time Delivery",
        75.percent
    ),
    Intelligence(
        "Intelligence",
        69.percent
    ),
    Understanding(
        "Understanding",
        55.percent
    )
}