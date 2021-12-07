package solutions

import readInput
import kotlin.math.abs

fun main() {

    fun parseInput(input: List<String>): Int {
        val positions = input.single()
            .split(",")
            .map { it.toInt() }

        val min = positions.minOrNull() ?: 0
        val max = positions.maxOrNull() ?: 0

        return (min..max).minOfOrNull { value ->
            positions.sumOf { position ->
                abs(value - position)
            }
        } ?: 0
    }

    fun part1(input: List<String>): Int {
        return parseInput(input)
    }

    fun part2(input: List<String>): Int {
        return parseInput(input)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day07_test")
    check(part1(testInput) == 37)
//    check(part2(testInput) == 0)

    val input = readInput("Day07")
    println(part1(input))
//    println(part2(input))
}