package com.c2v4.advent18

fun sumFrequency(input:String) = input.replace("\r\n","\n").split("\n").map { it.toInt() }.sum()

fun main(args: Array<String>) {
    println(sumFrequency("day1.txt".asResource()))
}