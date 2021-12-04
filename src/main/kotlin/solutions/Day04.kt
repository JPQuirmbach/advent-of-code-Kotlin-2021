package solutions

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        val instructions = input.first().split(",").map { it.toInt() }
        val boards = input
            .drop(1)
            .filter { it.isNotEmpty() }
            .windowed(5, 5)
            .map {
                it.map { row ->
                    row.split(" ")
                        .filter { it.isNotEmpty() }
                        .map { it.toInt() }
                        .toMutableList()
                }
            }

        instructions.forEach { number ->
            boards.forEach { board ->
                board.forEach { row ->
                    row.forEachIndexed { indexRow, value ->
                        if (value == number) {
                            row[indexRow] = -1
                        }
                    }
                }
                val bingo = board.checkBoardWon()
                if (bingo) {
                    val sum = board.sumOf {
                        it.filter { it > 0 }
                            .sum()
                    }
                    return sum * number
                }

            }
        }
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size

    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 4512)
//    check(part2(testInput) == 1924)

    val input = readInput("Day04")
    println(part1(input))
//    println(part2(input))
}

fun List<List<Int>>.checkBoardWon(): Boolean {
    for (row in indices) {
        if (this[row].all { it < 0 })
            return true
    }
    for (col in this[0].indices) {
        if (all { it[col] < 0 })
            return true
    }

    return false
}