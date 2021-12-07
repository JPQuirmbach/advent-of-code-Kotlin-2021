package solutions

import readInput
import kotlin.math.abs

fun main() {

    fun parseInput(input: List<String>, expensive: Boolean = false): Int {
        val positions = input.single()
            .split(",")
            .map { it.toInt() }

        val min = positions.minOrNull()
        val max = positions.maxOrNull()

        return (min!!..max!!).minOfOrNull { value ->
            positions.sumOf { position ->
                val diff = abs(value - position)
                if (expensive) {
                    diff * (diff + 1) / 2
                } else {
                    diff
                }
            }
        }!!
    }

    fun part1(input: List<String>): Int {
        return parseInput(input)
    }

    fun part2(input: List<String>): Int {
        return parseInput(input, true)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day07_test")
    check(part1(testInput) == 37)
    check(part2(testInput) == 168)

    val input = readInput("Day07")
    println(part1(input))
    println(part2(input))
}