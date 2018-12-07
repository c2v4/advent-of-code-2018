package com.c2v4.advent18

fun safeArea2(input: String,distance:Int): Int = input.split(splitRegex).map {
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
            val distanceSum = points.map { point -> manhattanDistance(point, x + xOffset, y + yOffset) }.sum()
            if (distanceSum < distance) map[x][y] = 1
        }
    }
    map.flatten().sum()
}

fun main(args: Array<String>) {
    println(safeArea2("day6.txt".asResource(),10000))
}
