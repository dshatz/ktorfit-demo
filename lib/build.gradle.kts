import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id ("com.google.devtools.ksp")
    id("de.jensklingenberg.ktorfit")
    id("org.jetbrains.kotlin.plugin.compose")
}

group = "com.dshatz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

kotlin {
    jvm()
    androidTarget()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.desktop.common)
                implementation("de.jensklingenberg.ktorfit:ktorfit-lib-light:2.0.0")
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                api("io.ktor:ktor-client-okhttp:2.3.10")
                runtimeOnly("io.ktor:ktor-client-core-jvm:2.3.10")
            }
        }
    }
}


compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "demo"
            packageVersion = "1.0.0"
        }
    }
}

android {
    namespace = "com.example"
    defaultConfig {
        minSdk = 24
        compileSdk = 34
    }
}
