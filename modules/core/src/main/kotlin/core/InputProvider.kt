package core

interface InputProvider {
    fun provideStringListInput(): List<String>
    fun provideStringInput(): String
    fun provideIntListInput(): List<Int>
    fun provideNestedIntListInput(): List<List<Int>>
    fun provideLongListInput(): List<Long>

    companion object {
        lateinit var provider: InputProvider
    }
}