package com.c2v4.advent18

import java.util.*
import kotlin.math.abs

fun marbleGame(input: String): Long = numberRegex.findAll(input).toList().let { results ->
    val players = results[0].value.toInt()
    val lastMarble = results[1].value.toInt()
    val board = LinkedList<Int>()
    board.add(0)
    val initial = MarbleGameState( board,  LongArray(players) { 0 })
    var i = 1
    while (i <= lastMarble) {
        if (i % 23 == 0) {
            initial.board.rotate(-7)
            initial.scores[i % players] += (i + initial.board.pop()).toLong()
        } else {
            initial.board.rotate(2)
            initial.board.addLast(i)
        }
        i++
    }
    initial.scores.max() ?: 0
}

fun <T> LinkedList<T>.rotate(num:Int){
    if (num == 0) return
    if (num > 0) {
        (0 until num).forEach {
            val t = this.removeLast()
            this.addFirst(t)
        }
    } else {
        (0 until (abs(num) -1)).forEach {
            val t = this.remove()
            this.addLast(t)
        }
    }
}

data class MarbleGameState(
    val board: LinkedList<Int>,
    val scores: LongArray
)

fun main(args: Array<String>) {
    println(marbleGame("day9.txt".asResource()))
}
