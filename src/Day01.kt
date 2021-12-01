fun main() {
    fun part1(input: List<String>): Int {
        var result = 0
        for ( i  in 1 until input.size)
            if(input[i].toInt() > input[i-1].toInt())
                result++
        return result
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
