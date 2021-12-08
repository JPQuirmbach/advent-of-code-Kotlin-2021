package solutions

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        val uniqueLength = setOf(2, 3, 4, 7)
        val outputSignals = input.map {
            it.split(" | ")[1]
        }.flatMap {
            it.split(" ")
        }
        return outputSignals.count {
            uniqueLength.contains(it.length)
        }
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day08_test")
    check(part1(testInput) == 26)
//    check(part2(testInput) == 168)

    val input = readInput("Day08")
    println(part1(input))
//    println(part2(input))
}