
plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id ("com.google.devtools.ksp")
    id("de.jensklingenberg.ktorfit")
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
                implementation("de.jensklingenberg.ktorfit:ktorfit-lib-light:1.13.0")
                implementation(project(":lib"))
            }
        }

        val jvmMain by getting {
            dependencies {
                api("io.ktor:ktor-client-okhttp:2.3.10")
                runtimeOnly("io.ktor:ktor-client-core-jvm:2.3.10")
            }
        }
    }
}


/*
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

*/

android {
    namespace = "com.example"
    defaultConfig {
        minSdk = 24
        compileSdk = 34
    }
}

dependencies {
    add("kspCommonMainMetadata", "de.jensklingenberg.ktorfit:ktorfit-ksp:1.13.0")
    add("kspJvm", "de.jensklingenberg.ktorfit:ktorfit-ksp:1.13.0")
}
