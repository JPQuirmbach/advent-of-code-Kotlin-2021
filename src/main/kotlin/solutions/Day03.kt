package solutions

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val gamma = input.first()
            .indices
            .map { column ->
                if (input.count { it[column] == '1' } > input.size / 2) '1' else '0'
            }
            .joinToString("")
        val epsilon = gamma.map { if (it == '1') '0' else '1' }.joinToString("")

        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
//    check(part2(testInput) == 5)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
