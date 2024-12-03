plugins {
    id(Plugins.libraryConventions.id)
    kotlin(Plugins.pluginKotlinJVM)
}

dependencies {
    implementation(Dependencies.Kotlin.gradlePlugin)
    implementation(Dependencies.Kotlin.stdLib)
}
