abstract class Puzzle<T, U>(val year: Int, val day: Int, val sample: Boolean = false) {
    val rawInput = getInput(year, day, sample)
    abstract val input: Any

    abstract fun solvePartOne(): T

    abstract fun solvePartTwo(): U
}