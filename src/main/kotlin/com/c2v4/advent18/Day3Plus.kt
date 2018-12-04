package com.c2v4.advent18

fun intactFabric(input: String): Int {
    val numberRegex = Regex("\\d+")
    return input.split(splitRegex)
        .map {
            val findAll = numberRegex.findAll(it).toList().map { it.value.toInt() }
            Claim(findAll[0], findAll[1], findAll[2], findAll[3], findAll[4])
        }
        .foldRight(Array(1000) { IntArray(1000) } to mutableSetOf<Int>())
        { (id, x, y, width, height), (acc,ids) ->
            var overlapped = false
            (x until width+x).forEach { xPos ->
                (y until height+y).forEach { yPos ->
                    if(acc[xPos][yPos]==0){
                        acc[xPos][yPos]=id
                    }else{
                        ids.remove(acc[xPos][yPos])
                        acc[xPos][yPos]=-1
                        overlapped = true
                    }
                }
            }
            if (!overlapped) ids.add(id)
            acc to ids
        }
        .second.elementAt(0)
}


fun main(args: Array<String>) {
    println(intactFabric("day3.txt".asResource()))
}