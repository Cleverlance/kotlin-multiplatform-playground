@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import co.touchlab.skie.configuration.DefaultArgumentInterop
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
    id("co.touchlab.skie") version "0.5.2"
}

kotlin {
    targetHierarchy.default()

    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.configure {
            dependencies {
                implementation("co.touchlab.skie:configuration-annotations:0.5.0")
            }
        }
    }

    XCFramework().apply {
        listOf(iosArm64(), iosSimulatorArm64()).forEach { target ->
            target.binaries.framework {
                baseName = "Multiplatform"
                add(this)
            }
        }
    }

    // https://github.com/touchlab/SKIE/issues/22
//    kotlinArtifacts {
//        Native.XCFramework("Multiplatform") {
//            targets(iosArm64, iosSimulatorArm64)
//            binaryOption("bundleId", "try.skie.ios")
//        }
//    }
}

skie {
    features {
        group("UltraUser") {
            DefaultArgumentInterop.Enabled(true)
        }
    }
}