package com.c2v4.advent18

import java.util.*

fun license(input: String): Int = calculateChecksum(input.split(" ").map { it.toInt() })

fun calculateChecksum(input: List<Int>): Int {
    var numbers = input
    var sum = 0
    val stackToAdd = LinkedList<Int>()
    val stackChildren = LinkedList<Int>()
    while (numbers.isNotEmpty()) {
        var children = numbers[0]
        var toSum = numbers[1]
        numbers = numbers.drop(2)
        if (children != 0) {
            stackChildren.push(children)
            stackToAdd.push(toSum)
        } else {
            while (children == 0) {
                sum += numbers.take(toSum).sum()
                numbers = numbers.drop(toSum)
                if (numbers.isNotEmpty()) {
                    children = stackChildren.pop() - 1
                    if (children == 0) {
                        toSum = stackToAdd.pop()
                    } else {
                        stackChildren.push(children)
                    }
                }else break
            }
        }
    }
    return sum
}

fun main(args: Array<String>) {
    println(license("day8.txt".asResource()))
}
