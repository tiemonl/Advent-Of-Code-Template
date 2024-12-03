rootProject.name = "AdventOfCodeTemplate"

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

// Modules
include(":modules:core")

// Years
include(":years:2024")