package core

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class FileInputProvider(private val metadata: PuzzleMetadata, private val suffix: String = "") : InputProvider {

    override fun provideStringListInput(): List<String> {
        return Files.readAllLines(getFile())
    }

    override fun provideStringInput(): String {
        return Files.readString(getFile())
    }

    override fun provideIntListInput(): List<Int> {
        return try {
            Files.readAllLines(getFile()).mapNotNull {
                it.toIntOrNull()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun provideNestedIntListInput(): List<List<Int>> {
        return try {
            Files.readAllLines(getFile()).mapNotNull {
                it.split(" ").mapNotNull { it.toIntOrNull() }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun provideLongListInput(): List<Long> {
        return try {
            Files.readAllLines(getFile()).mapNotNull {
                it.toLongOrNull()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    private fun getFile(): Path {
        val rootPath = getRootDirectory()
        val file = if (suffix.isEmpty()) "/input/${metadata.year}/main/input${metadata.day}.in" else "/input/${metadata.year}/test/input${metadata.day}$suffix.in"
        return Paths.get(rootPath+file)
    }

    private fun getRootDirectory(): String {
        val currentDir = System.getProperty("user.dir")

        return if (currentDir.contains("years")) {
            currentDir.split("/").dropLast(2).joinToString("/")
        } else {
            currentDir
        }
    }
}