package solutions

import readInput

fun main() {

    fun part1(input: List<String>): Int {

        val (instructions, boards) = parseInput(input)
        return boards.playBingo(instructions)
    }

    fun part2(input: List<String>): Int {

        val (instructions, boards) = parseInput(input)
        return boards.playBingo(instructions, true)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 4512)
    check(part2(testInput) == 1924)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}

fun parseInput(input: List<String>): Pair<List<Int>, MutableList<List<MutableList<Int>>>> {
    val instructions = input.first().split(",").map { it.toInt() }
    val boards = input
        .asSequence()
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
        }.toMutableList()
    return Pair(instructions, boards)
}

fun MutableList<List<MutableList<Int>>>.playBingo(
    instructions: List<Int>,
    removeBoardAfterBingo: Boolean = false
): Int {
    var lastBoardWonScore = 0

    instructions.forEach { number ->
        val iterator = this.iterator()
        while (iterator.hasNext()) {
            val board = iterator.next()
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
                lastBoardWonScore = sum * number

                if (removeBoardAfterBingo) {
                    iterator.remove()
                } else {
                    return lastBoardWonScore
                }
            }
        }
    }
    return lastBoardWonScore
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