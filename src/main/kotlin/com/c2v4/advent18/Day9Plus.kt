package com.c2v4.advent18

fun marbleGame2(input: String): Long {
    val value = numberRegex.findAll(input).toList()[1].value
    return marbleGame(input.replace(numberRegex.findAll(input).toList()[1].value, (value.toInt()*100).toString()))
}

fun main(args: Array<String>) {
    println(marbleGame2("day9.txt".asResource()))
}
