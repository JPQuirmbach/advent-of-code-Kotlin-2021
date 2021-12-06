package solutions

import readInput

fun main() {

    fun growthOfLanternfishes(input: List<String>, days: Int): Long {
        val lanternfishesDays = input.single()
            .split(",")
            .map { it.toInt() }

        val dayCounter = LongArray(9)
        lanternfishesDays.forEach { dayCounter[it]++ }

        repeat(days) {
            val zeros = dayCounter[0]
            for (i in 1 .. 8) {
                dayCounter[i - 1] = dayCounter[i]
            }
            dayCounter[6] += zeros
            dayCounter[8] = zeros
        }

        return dayCounter.sum()
    }

    fun part1(input: List<String>): Long {
        return growthOfLanternfishes(input, 80)
    }

    fun part2(input: List<String>): Long {
        return growthOfLanternfishes(input, 256)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 5934L)
    check(part2(testInput) == 26984457539)

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}