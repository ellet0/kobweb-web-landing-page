import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.*

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}

group = "com.ahmedhnewa.landingpagedemo"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Simple landing page built using kobweb and compose web")
            head.add {
                styleLink("https://fonts.googleapis.com/css2?family=Roboto&display=swap")
                styleLink("/assets/css/style.css")
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("landingpagedemo", includeServer = true)

    @Suppress("UNUSED_VARIABLE") // Suppress spurious warnings about sourceset variables not being used
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk.core)
                implementation(libs.kobweb.silk.icons.fa)
                implementation(libs.kobwebx.markdown)
             }
        }
        val jvmMain by getting {
            dependencies {
                implementation(libs.kobweb.api)
             }
        }
    }
}