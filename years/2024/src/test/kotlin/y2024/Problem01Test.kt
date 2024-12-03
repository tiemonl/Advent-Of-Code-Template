package y2024

import com.google.common.truth.Truth.assertThat
import core.FileInputProvider
import core.PuzzleMetadata
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2024 Day 1")
internal class Problem01Test {

    val metadata = PuzzleMetadata(year = 2024, day = 1)

    @Nested
    @DisplayName("Part 1")
    inner class PartOne {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem01(FileInputProvider(metadata, "_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(-1)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem01(FileInputProvider(metadata))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(-1)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class PartTwo {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem01(FileInputProvider(metadata, "_1"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(-1)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem01(FileInputProvider(metadata))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(-1)
        }
    }
}
