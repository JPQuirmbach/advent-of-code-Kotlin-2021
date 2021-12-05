package solutions

import readInput
import java.lang.Integer.max
import java.lang.Integer.min
import kotlin.math.abs

fun main() {

    fun parseInput(input: List<String>): Pair<List<Line>, Pair<Int, Int>> {
        var maxX = 0
        var maxY = 0
        val lines = input.map { line ->
            val (p1, p2) = line.split(" -> ").map { point ->
                val (x, y) = point.split(",").map { it.toInt() }
                maxX = maxOf(maxX, x)
                maxY = maxOf(maxY, y)
                Point(x, y)
            }
            Line(p1, p2)
        }
        return Pair(lines, Pair(maxX, maxY))
    }

    fun part1(input: List<String>): Int {
        val (lines, max) = parseInput(input)
        val grid = Array(max.second + 1) { Array(max.first + 1) { 0 } }
        lines.filter { line -> line.p1.x == line.p2.x || line.p1.y == line.p2.y }
            .forEach { line ->
                val (p1, p2) = line
                if (p1.x == p2.x) {
                    for (y in min(p1.y, p2.y)..max(p1.y, p2.y)) {
                        grid[y][p1.x]++
                    }
                } else if (p1.y == p2.y) {
                    for (x in min(p1.x, p2.x)..max(p1.x, p2.x)) {
                        grid[p1.y][x]++
                    }
                }
            }
        return grid.sumOf { it.count { it > 1 } }
    }

    fun part2(input: List<String>): Int {
        val (lines, max) = parseInput(input)
        val grid = Array(max.second + 1) { Array(max.first + 1) { 0 } }
        lines.filter { line ->
            line.p1.x == line.p2.x || line.p1.y == line.p2.y ||
                    abs(line.p1.x - line.p2.x) == abs(line.p1.y - line.p2.y)
        }
            .forEach { line ->
                val (p1, p2) = line
                if (p1.x == p2.x) {
                    for (y in min(p1.y, p2.y)..max(p1.y, p2.y)) {
                        grid[y][p1.x]++
                    }
                } else if (p1.y == p2.y) {
                    for (x in min(p1.x, p2.x)..max(p1.x, p2.x)) {
                        grid[p1.y][x]++
                    }
                } else {
                    val d = abs(p1.x - p2.x)
                    val dx = (p2.x - p1.x) / d
                    val dy = (p2.y - p1.y) / d
                    for (i in 0..d) {
                        grid[p1.y + dy * i][p1.x + dx * i]++
                    }
                }
            }
        return grid.sumOf { it.count { it > 1 } }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == 5)
    check(part2(testInput) == 12)

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}

data class Point(val x: Int, val y: Int)

data class Line(val p1: Point, val p2: Point)