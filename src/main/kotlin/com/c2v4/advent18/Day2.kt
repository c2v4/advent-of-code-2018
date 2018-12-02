package com.c2v4.advent18

fun checksum(input: String) =
    input.split(splitRegex).map { exactlyTwice(it).toInt() to exactlyThreeTimes(it).toInt() }.foldRight(
        0 to 0
    ) { pair, acc -> (acc.first + pair.first) to (pair.second + acc.second) }.let { (first, second) -> first * second }

fun exactlyTwice(input: String) = containsDuplicatedLetterExactly(input, 2)
fun exactlyThreeTimes(input: String) = containsDuplicatedLetterExactly(input, 3)
fun containsDuplicatedLetterExactly(input: String, times: Int) =
    input.toCharArray().toTypedArray().groupingBy { it }.eachCount().values.contains(times)

fun Boolean.toInt() = if (this) 1 else 0

fun main(args: Array<String>) {
    println(checksum("day2.txt".asResource()))
}