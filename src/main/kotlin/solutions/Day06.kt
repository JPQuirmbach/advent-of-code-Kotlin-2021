package solutions

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        val lanternfishes = input.single()
            .split(",")
            .map { Lanternfish(it.toInt()) }
            .toMutableList()

        repeat(80) {
            for (lanternfish in lanternfishes) {
                lanternfish.days--
            }

            lanternfishes.filter { it.days < 0 }
                .forEach {
                    it.days = 6;
                    lanternfishes.add(Lanternfish(8))
                }
        }

        return lanternfishes.size
    }

    fun part2(input: List<String>): Int {
        return input.size

    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 5934)
//    check(part2(testInput) == 12)

    val input = readInput("Day06")
    println(part1(input))
//    println(part2(input))
}

data class Lanternfish(var days: Int)