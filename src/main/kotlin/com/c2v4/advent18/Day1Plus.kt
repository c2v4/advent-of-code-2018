package com.c2v4.advent18

fun repeatedFrequency(input: String): Int {
    val changes = input.split(splitRegex).map { it.toInt() }
    val alreadyVisited = mutableSetOf(0)
    var current = 0
    var index = 0
    while (true) {
        current += changes[index]
        if (alreadyVisited.contains(current)) return current
        alreadyVisited.add(current)
        index = (index + 1) % changes.size
    }
}

fun main(args: Array<String>) {
    println(repeatedFrequency("day1.txt".asResource()))
}