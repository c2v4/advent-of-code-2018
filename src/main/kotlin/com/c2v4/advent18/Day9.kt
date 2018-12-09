package com.c2v4.advent18

fun marbleGame(input: String): Int = numberRegex.findAll(input).toList().let {
    val players = it[0].value.toInt()
    val lastMarble = it[1].value.toInt()
    (1..lastMarble).fold(MarbleGameState(0, mutableListOf(0), 1, MutableList(players) { 0 })) { acc, i ->
        if (i % 23 == 0) {
            val toRemovePos =     (acc.lastMarblePos - 7+acc.board.size)%acc.board.size
            acc.scores[acc.currentPlayer] =
                acc.scores[acc.currentPlayer] + i + acc.board.removeAt(toRemovePos)
            acc.lastMarblePos = toRemovePos
        } else {
            val newMarblePos = ((acc.lastMarblePos + 1) % acc.board.size)+1
            acc.board.add(newMarblePos,i)
            acc.lastMarblePos=newMarblePos
        }
        acc.currentPlayer = (acc.currentPlayer + 1) % players
        acc
    }.scores.max() ?: 0
}

data class MarbleGameState(
    var currentPlayer: Int,
    val board: MutableList<Int>,
    var lastMarblePos: Int,
    val scores: MutableList<Int>
)

fun main(args: Array<String>) {
    println(marbleGame("day9.txt".asResource()))
}
