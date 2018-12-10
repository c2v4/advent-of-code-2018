package com.c2v4.advent18

import kotlin.math.min

fun navigationMessage(input: String):String = parsePoints(input).let {
    var points = it.map { it.first }
    val speeds = it.map { it.second }
    var entropy = Float.MAX_VALUE
    var last: Set<Point> = emptySet()
    while (true) {
        val pointsAsSet = points.toSet()
        val newEntropy = ultraFastEntropy(pointsAsSet)
        if (newEntropy > entropy) {
            return@let printPoints(last)
        }
        entropy = newEntropy
        last = pointsAsSet
        points = points.mapIndexed { index, point -> Point(point.x + speeds[index].x, point.y + speeds[index].y) }
    }
    return@let ""
}

fun ultraFastEntropy(input: Set<Point>): Float {
    val xMin = input.minBy { it.x }?.x ?: 0
    val yMin = input.minBy { it.y }?.y ?: 0
    val xMax = input.maxBy { it.x }?.x ?: 0
    val yMax = input.maxBy { it.y }?.y ?: 0
    val xSize = xMax - xMin + 1
    val ySize = yMax - yMin + 1
    return min(xSize, ySize).toFloat()
}

fun fastEntropy(input: Set<Point>) = 1f / input.map { manhattanDistance(Point(0, 0), it) }.sum()

fun entropy(input: Set<Point>): Float {
    var sum = 0
    val toVisit = input.toMutableSet()
    while (toVisit.isNotEmpty()) {
        val current = toVisit.first()
        toVisit.remove(current)
        var i = 1
        while (true) {
            val toCheck = current.copy(x = current.x - i)
            if (input.contains(toCheck)) {
                sum++
                i++
                toVisit.remove(toCheck)
            } else {
                break
            }
        }
        i = 1
        while (true) {
            val toCheck = current.copy(x = current.x + i)
            if (input.contains(toCheck)) {
                sum++
                i++
                toVisit.remove(toCheck)
            } else {
                break
            }
        }
        i = 1
        while (true) {
            val toCheck = current.copy(y = current.y - i)
            if (input.contains(toCheck)) {
                sum++
                i++
                toVisit.remove(toCheck)
            } else {
                break
            }
        }
        i = 1
        while (true) {
            val toCheck = current.copy(y = current.y + i)
            if (input.contains(toCheck)) {
                sum++
                toVisit.remove(toCheck)
                i++
            } else {
                break
            }
        }
    }
    return 1.0f / sum
}

fun printPoints(input: Set<Point>): String {
    val xMin = input.minBy { it.x }?.x ?: 0
    val yMin = input.minBy { it.y }?.y ?: 0
    val xMax = input.maxBy { it.x }?.x ?: 0
    val yMax = input.maxBy { it.y }?.y ?: 0
    val xSize = xMax - xMin + 1
    val ySize = yMax - yMin + 1
    val grid = Array(ySize) { Array(xSize) { '.' } }
    input.forEach {
        grid[it.y - yMin][it.x - xMin] = '#'
    }
    return grid.joinToString("\n") { it.joinToString("") }
}

fun parsePoints(input: String) = input.split(splitRegex)
    .map { numberRegex.findAll(it).toList().map { it.value.toInt() } }
    .map { Point(it[0], it[1]) to Point(it[2], it[3]) }
    .toSet()

fun main(args: Array<String>) {
    println(navigationMessage("day10.txt".asResource()))
}
