package com.c2v4.advent18

import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.atan2

fun safeArea(input: String): Int = input.split(splitRegex).map {
    val split = it.split(", ")
    Point(split[0].toInt(), split[1].toInt())
}.let { points ->
    val xOffset = points.minBy { it.x }?.x ?: 0
    val xMax = points.maxBy { it.x }?.x ?: 0
    val yOffset = points.minBy { it.y }?.y ?: 0
    val yMax = points.maxBy { it.y }?.y ?: 0
    val xSize = xMax - xOffset + 1
    val ySize = yMax - yOffset + 1
    val map = Array(xSize) { Array(ySize) { 0 } }
    (0 until xSize).forEach { x ->
        (0 until ySize).forEach { y ->
            val distances = points.map { point -> manhattanDistance(point, x + xOffset, y + yOffset) }
            val min = distances.min() ?: -1
            val closestPoints = distances.foldIndexed(mutableListOf<Int>()) { index, acc, i ->
                if (i == min) acc.add(index)
                acc
            }
            if (closestPoints.size == 1) map[x][y] = closestPoints[0]
            else map[x][y] = -1
        }
    }
    val areas = map.flatten().groupingBy { it }.eachCount().toMutableMap()
    areas.remove(-1)
    minimalPolygon(points).forEach { areas.remove(points.indexOf(it)) }
    areas.values.max()?:-1
}

fun manhattanDistance(first: Point, secondX: Int, secondY: Int) = abs(first.x - secondX) + abs(first.y - secondY)

fun manhattanDistance(first: Point, second: Point): Int = abs(first.x - second.x) + abs(first.y - second.y)

fun minimalPolygon(input: List<Point>): List<Point> {
    if (input.isEmpty() || input.size < 4) return input
    var current = input.minBy { it.x }!!
    val polygon = mutableListOf(current)
    while (true) {
        val next = input.minus(polygon.takeLast(2)).minBy { angle(current, it) }!!
        if (polygon.contains(next)) return polygon
        polygon.add(next)
        current = next
    }
}

fun angle(from: Point, to: Point): Double {
    val d = (3 * PI / 2) - atan2((to.y - from.y).toDouble(), (to.x - from.x).toDouble()) + Double.MIN_VALUE
    return if (d < 2 * PI) d else d - 2 * PI
}

data class Point(val x: Int, val y: Int)


fun main(args: Array<String>) {
    println(safeArea("day6.txt".asResource()))
}
