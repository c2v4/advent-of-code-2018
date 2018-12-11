package com.c2v4.advent18

fun mostPowerfulGridVariable(input: String, size: Int = 300): String = mostPowerfulGridVariable(input.toInt(), size)

fun mostPowerfulGridVariable(serial: Int, size: Int = 300): String {
    val partialSums = Array(size) { x -> Array(size) { y -> cellPower(x, y, serial) } }
    (0 until size).forEach { x ->
        (0 until size).forEach { y ->
            partialSums[x][y] = partialSums[x][y] + (partialSums.getOrNull(x - 1)?.getOrNull(y) ?: 0) +
                (partialSums.getOrNull(x)?.getOrNull(y - 1) ?: 0) -
                (partialSums.getOrNull(x - 1)?.getOrNull(y - 1) ?: 0)
        }
    }
    return (0 until size).toList().parallelStream().flatMap { x ->
        (0 until size).toList().parallelStream().flatMap { y ->
            (0..(size - maxOf(x, y) - 1)).toList().parallelStream().map { varSize ->
                Triple(
                    x + 1,
                    y + 1,
                    varSize
                ) to partialSums[x][y] + partialSums[x + varSize][y + varSize] - partialSums[x + varSize][y] - partialSums[x][y + varSize]
            }
        }
    }.max { o1, o2 -> o1.second.compareTo(o2.second) }.map { it.first }.map { (x, y, size) -> "$x,$y,$size" }.orElse("")
}

/* Abandoned */
//class MemoGrid(private val grid: Array<Array<Int>>) {
//
//    private val valueMap = ConcurrentHashMap<Triple<Int, Int, Int>, Int>()
//
//    private fun getSumFor(input: Triple<Int, Int, Int>): Int {
//        if (input.third == 0) return 0
//        val value = valueMap[input]
//        if (value == null) {
//            val toAdd = calculateSquareSum(input)
//            valueMap[input] = toAdd
//            return toAdd
//        }
//        return value
//    }
//
//    fun getSumFor(x: Int, y: Int, size: Int): Int = getSumFor(Triple(x, y, size))
//
//    private fun calculateSquareSum(input: Triple<Int, Int, Int>): Int =
//        calculateSquareSum(input.first, input.second, input.third)
//
//    private fun calculateSquareSum(x: Int, y: Int, s: Int): Int {
//        if (s == 0) return 0
//        if (s == 1) return grid[x][y]
//        val halfSize = s / 2
//        return getSumFor(x, y, halfSize) + getSumFor(
//            x + halfSize,
//            y + halfSize,
//            s - halfSize
//        ) + calculateRect(x + halfSize, y, x + s - 1, y + halfSize - 1) +
//            calculateRect(
//                x,
//                y + halfSize,
//                x + halfSize - 1,
//                y + s - 1
//            )
//    }
//
//    private fun calculateRect(xStart: Int, yStart: Int, xEnd: Int, yEnd: Int): Int {
//        val xSize = xEnd - xStart + 1
//        val ySize = yEnd - yStart + 1
//        if (xSize == 0 || ySize == 0) return 0
//        val s = min(xSize, ySize)
//        if (xSize == ySize) return calculateSquareSum(xStart, yStart, s)
//        return getSumFor(xStart, yStart, s) + if (xSize > ySize) calculateRect(
//            xStart + s,
//            yStart,
//            xEnd,
//            yEnd
//        ) else calculateRect(xStart, yStart + s, xEnd, yEnd)
//    }
//}

fun main(args: Array<String>) {
    println(mostPowerfulGridVariable("day11.txt".asResource()))
}
