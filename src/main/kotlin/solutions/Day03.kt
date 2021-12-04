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
        val epsilon = gamma
            .map {
                if (it == '1') '0' else '1'
            }
            .joinToString("")

        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun part2(input: List<String>): Int {
        val oxygen = input.findRating(true)
        val co2 = input.findRating(false)

        return oxygen * co2
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

fun List<String>.findRating(switch: Boolean): Int {
    var mutableInput = this.map { it }
    var i = 0
    while (mutableInput.size > 1) {
        val zeros = mutableInput.count { it[i] == '0' }
        val ones = mutableInput.count { it[i] == '1' }

        mutableInput = if (switch) {
            mutableInput.filter { it[i] == if (zeros > ones) '0' else '1' }
        } else {
            mutableInput.filter { it[i] == if (zeros <= ones) '0' else '1' }
        }

        i = (i + 1) % mutableInput.first().length
    }
    return mutableInput.first().toInt(2)
}
