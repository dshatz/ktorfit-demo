pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
    }

    plugins {
        kotlin("multiplatform").version(extra["kotlin.version"] as String)
        id("org.jetbrains.compose").version(extra["compose.version"] as String)
        id("org.jetbrains.kotlin.plugin.compose").version(extra["kotlin.version"] as String)
        id ("com.google.devtools.ksp") version "2.0.0-1.0.22"
        id("de.jensklingenberg.ktorfit") version "2.0.0"
        id("com.android.application") version "8.1.0" apply false
        id("com.android.library") version "8.1.0" apply false
    }
}

rootProject.name = "demo"
include(":lib")
