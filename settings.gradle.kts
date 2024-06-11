pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
    }

    plugins {
        kotlin("multiplatform").version(extra["kotlin.version"] as String)
        id ("com.google.devtools.ksp") version "1.9.23-1.0.20"
        id("de.jensklingenberg.ktorfit") version "1.13.0"
        id("com.android.application") version "8.1.0" apply false
        id("com.android.library") version "8.1.0" apply false
    }
}

rootProject.name = "demo"
include(":lib")
