package core

class StringInputProvider(private val input: String, private val delimiter: String = "\n") : InputProvider {
    override fun provideStringListInput(): List<String> {
        return input.split(delimiter)
    }

    override fun provideStringInput(): String {
        return input
    }

    override fun provideIntListInput(): List<Int> {
        return input.split(delimiter).mapNotNull { it.toIntOrNull() }
    }

    override fun provideNestedIntListInput(): List<List<Int>> {
        return input.split(delimiter).map { it.split("\n").mapNotNull { it.toIntOrNull() } }
    }

    override fun provideLongListInput(): List<Long> {
        return input.split(delimiter).mapNotNull { it.toLongOrNull() }
    }
}