package core

abstract class Puzzle<T, U>(
    val metadata: PuzzleMetadata
) {
    abstract val input: Any

    abstract fun solvePartOne(): T

    abstract fun solvePartTwo(): U
}
