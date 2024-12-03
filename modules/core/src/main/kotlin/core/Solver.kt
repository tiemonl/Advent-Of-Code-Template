package core

import kotlin.system.measureNanoTime

fun <T : Any, R : Any> solve(benchmark: Boolean = false, block: () -> Puzzle<T, R>) {
    InputProvider.provider = FileInputProvider(block().metadata)
    printResult(block)
    if (benchmark) {
        println()
        benchmark(block)
    }
}

fun <T : Any, R : Any> printResult(block: () -> Puzzle<T, R>) {
    val puzzle = block()
    val partOneResult = puzzle.solvePartOne().bold(CYAN)
    val partTwoResult = puzzle.solvePartTwo().bold(CYAN)
    println("${puzzle.metadata.year} - Day ${puzzle.metadata.day}\n${puzzle.metadata.name}".style(YELLOW))
    println("Part 1: $partOneResult")
    println("Part 2: $partTwoResult")
}

private fun benchmark(block: () -> Puzzle<*, *>) {
    print("Benchmarking...")
    var initTime = 0L
    var partOneTime = 0L
    var partTwoTime = 0L
    var times = 0
    while (times < 10000) {
        times++
        if (times % 100 == 0) print("\rBenchmarking... ($times runs)")
        lateinit var p: Puzzle<*, *>
        initTime += measureNanoTime { p = block() }
        partOneTime += measureNanoTime { p.solvePartOne() }
        partTwoTime += measureNanoTime { p.solvePartTwo() }
    }
    initTime /= times
    partOneTime /= times
    partTwoTime /= times

    print("\n")
    printBenchmark(times, initTime.toMillis(), partOneTime.toMillis(), partTwoTime.toMillis())
}

private fun printBenchmark(times: Int, initTime: Float, partOneTime: Float, partTwoTime: Float) {
    println("Initialization took " + "%.3fms".format(initTime).bold(YELLOW))
    printPartBenchmark(1, partOneTime, initTime)
    printPartBenchmark(2, partTwoTime, initTime)
    println(
        "Total: " + "%.3fms".format(initTime + partOneTime + partTwoTime).bold(YELLOW) + " (avg. of " + times.toString()
            .bold() + " runs)",
    )
}

private fun printPartBenchmark(part: Int, time: Float, initTime: Float) {
    println(
        "Part $part took " +
                "%.3fms".format(time).bold(YELLOW) +
                ", including init: " +
                "%.3fms".format((initTime + time)).bold(YELLOW),
    )
}

private fun Long.toMillis() = this / 1000000f

private fun Any.bold(color: String = "") = style("$color;1")

private fun Any.style(color: String) = "\u001B[${color}m$this\u001B[0m"

private fun String.christmas() = buildString {
    var green = true
    this@christmas.toCharArray().forEach {
        val color = if (green) GREEN else RED
        if (!it.isWhitespace()) {
            append(it.bold(color))
            green = !green
        } else append(it)
    }
}

private const val RED = "31"
private const val GREEN = "32"
private const val YELLOW = "33"
private const val CYAN = "36"