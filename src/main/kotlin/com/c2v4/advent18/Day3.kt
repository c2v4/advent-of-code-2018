package com.c2v4.advent18

fun overlappingFabric(input: String): Int {
    val numberRegex = Regex("\\d+")
    return input.split(splitRegex)
        .map {
            val findAll = numberRegex.findAll(it).toList().map { it.value.toInt() }
            Claim(findAll[0], findAll[1], findAll[2], findAll[3], findAll[4])
        }
        .foldRight(Array(1000) { IntArray(1000) })
        { (id, x, y, width, height), acc ->
            (x until width+x).forEach { xPos ->
                (y until height+y).forEach { yPos ->
                    if(acc[xPos][yPos]==0){
                        acc[xPos][yPos]=id
                    }else{
                        acc[xPos][yPos]=-1
                    }
                }
            }
            acc
        }
        .sumBy { it.count { it == -1 } }
}

data class Claim(val id: Int, val x: Int, val y: Int, val width: Int, val height: Int)


fun main(args: Array<String>) {
    println(overlappingFabric("day3.txt".asResource()))
}