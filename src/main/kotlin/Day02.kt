package day1

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var horizontal = 0
        var vertical = 0

        for (it in input) {
            val (dir, amount) = it.split(" ")
            when (dir) {
                "forward" -> horizontal += amount.toInt()
                "down" -> vertical += amount.toInt()
                "up" -> vertical -= amount.toInt()
            }
        }

        return horizontal * vertical
    }

    fun part2(input: List<String>): Int {
        var horizontal = 0
        var vertical = 0
        var aim = 0

        for (it in input) {
            val (dir, amount) = it.split(" ")
            when (dir) {
                "forward" -> {
                    horizontal += amount.toInt()
                    vertical += aim * amount.toInt()
                }
                "down" -> aim += amount.toInt()
                "up" -> aim -= amount.toInt()
            }
        }

        return horizontal * vertical
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}