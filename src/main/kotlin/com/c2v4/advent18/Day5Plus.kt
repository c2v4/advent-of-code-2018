package com.c2v4.advent18

fun polymerRemove(input: String): Int = input
    .toLowerCase()
    .toCharArray()
    .asList()
    .distinct()
    .map {
        polymerReduction(
            input.replace(it.toString(), "", true)
        )
    }
    .min() ?: 0

fun main(args: Array<String>) {
    println(polymerRemove("day5.txt".asResource()))
}