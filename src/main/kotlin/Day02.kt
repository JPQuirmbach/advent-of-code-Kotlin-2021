package day1

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var horizontal = 0
        var vertical = 0
        for (i in input.indices) {
            val split = input[i].split(" ")
            val dir = Direction.valueOf(split[0])
            val amount = split[1]
            when (dir) {
                Direction.forward -> horizontal += amount.toInt()
                Direction.down ->  vertical += amount.toInt()
                Direction.up -> vertical -= amount.toInt()
            }
        }

        return horizontal * vertical
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
//    check(part2(testInput) == 5)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

enum class Direction {
    forward,
    down,
    up
}
