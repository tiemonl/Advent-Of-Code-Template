package y2024

import core.FileInputProvider
import core.InputProvider
import core.Puzzle
import core.PuzzleMetadata
import core.solve

fun main() = solve(
    benchmark = false,
) { Problem01() }

class Problem01(
    inputProvider: InputProvider = FileInputProvider(METADATA)
 ): Puzzle<Any, Any>(
    metadata = METADATA,
) {
    override val input = inputProvider.provideStringListInput()

    override fun solvePartOne(): Any {
        return 0
    }

    override fun solvePartTwo(): Any {
        return 0
    }

    companion object {
        val METADATA = PuzzleMetadata(year = 2024, day = 1, name = "Historian Hysteria")
    }
}
