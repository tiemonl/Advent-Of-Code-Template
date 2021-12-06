package y2021

import Puzzle
import solve

fun main() = solve(
    benchmark = true
) { Problem00() } // TODO: change class name call

// TODO: change class name to match problem number and day parameter
class Problem00 : Puzzle<Int, Int>(
    year = 2021,
    day = 0,
    sample = false
) {
    override val input = rawInput.map { it.toInt() }

    override fun solvePartOne(): Int {
        return 0
    }

    override fun solvePartTwo(): Int {
        return 0
    }
}