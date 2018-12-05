package com.c2v4.advent18

fun polymerReduction(input: String): Int = input.toCharArray().asList().let {
    var current = it
    while (true) {
        val new = current.fold(mutableListOf<Char>()) { acc, c ->
            if (c.invertCase() == (acc.lastOrNull() ?: 0)) acc.removeAt(acc.size-1)
            else acc.add(c)
            acc
        }
        if (new.size == current.size) return@let new.size
        current = new
    }
    -1
}

fun Char.invertCase() = this.toInt().xor(32).toChar()

fun main(args: Array<String>) {
    println(polymerReduction("day5.txt".asResource()))
}