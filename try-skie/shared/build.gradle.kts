import co.touchlab.skie.configuration.DefaultArgumentInterop

plugins {
    kotlin("multiplatform")
    id("co.touchlab.skie") version "0.5.5"
}

kotlin {
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.configure {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
                implementation("co.touchlab.skie:configuration-annotations:0.5.5")
            }
        }
    }

    kotlinArtifacts {
        Native.XCFramework("Multiplatform") {
            targets(iosArm64, iosSimulatorArm64)
            binaryOption("bundleId", "try.skie.ios")
        }
    }
}

skie {
    features {
        group("UltraUser") {
            DefaultArgumentInterop.Enabled(true)
        }
    }
}