package com.c2v4.advent18

fun navigationMessageTime(input: String):Int = parsePoints(input).let {
    var points = it.map { it.first }
    val speeds = it.map { it.second }
    var entropy = Float.MAX_VALUE
    var time = -1
    while (true) {
        val pointsAsSet = points.toSet()
        val newEntropy = ultraFastEntropy(pointsAsSet)
        if (newEntropy > entropy) {
            return@let time
        }
        time++
        entropy = newEntropy
        points = points.mapIndexed { index, point -> Point(point.x + speeds[index].x, point.y + speeds[index].y) }
    }
    return@let 0
}

fun main(args: Array<String>) {
    println(navigationMessageTime("day10.txt".asResource()))
}
