@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
}

kotlin {
    targetHierarchy.default()

    iosArm64()
    iosSimulatorArm64()

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