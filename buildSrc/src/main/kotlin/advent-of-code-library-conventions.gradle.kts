version = "1.0"

plugins {
    application
}

repositories {
    mavenCentral()
    google()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

apply {
    from("$rootDir/config/gradle_tests_report.gradle.kts")
}
