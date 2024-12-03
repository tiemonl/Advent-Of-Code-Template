object Plugins {
    data class Plugin(val id: String, val coordinates: String)

    val libraryConventions = Plugin("advent-of-code-library-conventions", "N/A")
    const val pluginKotlinJVM = "jvm"
    const val pluginKotlinSerialization = "plugin.serialization"
}
