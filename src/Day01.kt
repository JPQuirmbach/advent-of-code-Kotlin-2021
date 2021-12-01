fun main() {
    fun part1(input: List<String>): Int {
        val intList = input.map { it.toInt() }
        var result = 0
        for (i in 1 until intList.size) {
            if (intList[i] > intList[i - 1]) {
                result++
            }
        }
        return result
    }

    fun part2(input: List<String>): Int {
        val intList = input.map { it.toInt() }
        var result = 0
        for (i in 0 until intList.size - 3) {
            val sum1 = intList.slice(i..i + 2).sum()
            val sum2 = intList.slice(i + 1..i + 3).sum()
            if (sum2 > sum1) {
                result++
            }
        }
        return result
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
