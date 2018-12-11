package com.c2v4.advent18

fun mostPowerfullGrid(input: String, size: Int = 300): String = mostPowerfullGrid(input.toInt(), size)

fun mostPowerfullGrid(serial: Int, size: Int = 300): String {
    val grid = Array(size) { x -> Array(size) { y -> cellPower(x, y, serial) } }
    return (0 until size - 2).flatMap { x ->
        (0 until size - 2).map { y ->
            (x to y) to grid.sliceArray(x..x + 2).flatMap { it.slice(y..y + 2) }.sum()
        }
    }.maxBy { it.second }?.first?.let { (x, y) -> "$x,$y" } ?: ""
}

fun cellPower(x: Int, y: Int, serial: Int) = (((((x + 10) * y) + serial) * (x + 10) / 100) % 10) - 5

fun main(args: Array<String>) {
    println(mostPowerfullGrid("day11.txt".asResource()))
}
