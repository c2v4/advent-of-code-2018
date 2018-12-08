package com.c2v4.advent18

import java.util.*

fun licenseMeta(input: String): Int = calculateChecksumMeta(input.split(" ").map { it.toInt() })

fun calculateChecksumMeta(input: List<Int>): Int {
    var numbers = input
    val stackToAdd = LinkedList<Int>()
    val stackChildren = LinkedList<Int>()
    val stackChildrenOriginal = LinkedList<Int>()
    var values = mutableListOf<Int>()
    while (numbers.isNotEmpty()) {
        var children = numbers[0]
        var toSum = numbers[1]
        numbers = numbers.drop(2)
        if (children != 0) {
            stackChildren.push(children)
            stackChildrenOriginal.push(children)
            stackToAdd.push(toSum)
        } else {
            values.add(numbers.take(toSum).sum())
            numbers = numbers.drop(toSum)
            while (children == 0 && numbers.isNotEmpty()) {
                children = stackChildren.pop() - 1
                if (children == 0) {
                    val limit = stackChildrenOriginal.pop()
                    toSum = stackToAdd.pop()
                    val sum = numbers.take(toSum)
                        .map { if (it > limit) 0 else values.takeLast(limit)[it - 1] }.sum()
                    numbers = numbers.drop(toSum)
                    values = values.dropLast(limit).toMutableList()
                    values.add(sum)
                } else {
                    stackChildren.push(children)
                }
            }
        }
    }

    return values[0]
}

fun main(args: Array<String>) {
    println(licenseMeta("day8.txt".asResource()))
}
