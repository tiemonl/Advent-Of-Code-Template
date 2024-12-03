import org.gradle.kotlin.dsl.DependencyHandlerScope

object Dependencies {
    object Kotlin {
        val stdLib by lazy { "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}" }
        val gradlePlugin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    }

    object KotlinX {
        val serialization by lazy { "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}" }
    }

    object Testing {
        val junitBom by lazy { "org.junit:junit-bom:${Versions.jUnit}" }
        val junitJupiter by lazy { "org.junit.jupiter:junit-jupiter" }
        val truth by lazy { "com.google.truth:truth:${Versions.truth}" }

        fun DependencyHandlerScope.simpleTesting() {
            add(configurationName = "testImplementation", dependencyNotation = truth)
            add(configurationName = "testImplementation", dependencyNotation = junitJupiter)
        }
    }
}
