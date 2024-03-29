package com.ahmedhnewa.landingpagedemo.sections.testimonial.models

import com.ahmedhnewa.landingpagedemo.utils.constants.Res

enum class Testimonial(
    val image: String,
    val fullName: String,
    val profession: String,
    val review: String
) {
    First(
        image = Res.Assets.Images.Testimonials.ALBERT_EINSTEIN,
        fullName = "Albert Einstein",
        profession = "Software developer",
        review = "I have never met this man in my life and I never will, amidst the digital symphony of ones and zeros, you wield your keyboard like a maestro's baton, composing lines of code that dance to the rhythm of innovation. With every keystroke, you're writing the future of technology, crafting a melody that echoes through the corridors of progress."
    ),
    Second(
        image = Res.Assets.Images.Testimonials.STEVE_JOBS,
        fullName = "Steve Jobs",
        profession = "Electric scientist",
        review = "Embarking on a journey of creativity, you weave code and colors into a digital tapestry that dances with innovation. With each keystroke, you're like a modern-day alchemist, turning ideas into pixels and dreams into reality."
    ),
    Third(
        image = Res.Assets.Images.Testimonials.THOMAS_EDISON,
        fullName = "Thomas Edison",
        profession = "CEO of Apple",
        review = "Navigating through the binary seas of code, you're the captain of your digital ship, steering through the waves of algorithms and syntax with confidence and curiosity. Your quest for knowledge and creation sets you on a course for innovation's horizon."
    ),
    Fourth(
        image = Res.Assets.Images.Testimonials.JOHN_WICK,
        fullName = "John wick",
        profession = "Retired Assassin",
        review = "I don't know much about this guy but I know he didn't kill my dog and never will"
    ),
    Fifth(
        image = Res.Assets.Images.Testimonials.MARCIN_IWINSKI,
        fullName = "Marcin Iwinski",
        profession = "2077",
        review = "Like a conductor of technology's symphony, you orchestrate lines of code that harmonize into digital melodies. Your keyboard is your baton, and your monitor is the stage where your ideas take center stage, captivating the world with your technological compositions."
    ),
    Sixth(
        image = Res.Assets.Images.Testimonials.UNCLE_BOB,
        fullName = "Robert C. Martin",
        profession = "Clean Guy",
        review = "Uncle Bob think he can save his and others code and he is right, In the vast galaxy of the internet, you're the intrepid explorer, venturing through websites and codebases like a modern-day astronaut. Your curiosity fuels your journey, and your keyboard becomes your spacecraft's control panel as you navigate the cosmos of information."
    ),
    Seven(
        image = Res.Assets.Images.Testimonials.MARCIN_IWINSKI,
        fullName = "Marcin Iwinski",
        profession = "2013",
        review = "Not much left here"
    ),
}