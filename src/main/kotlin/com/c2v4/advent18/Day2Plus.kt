package com.c2v4.advent18

fun closeID(input: String):String {
    val split = input.split(splitRegex)
    val idHolder = IdHolder(split[0])

    split.drop(1).forEach {
        val closeAndAdd = idHolder.isCloseAndAdd(it)
        if (closeAndAdd != null) return closeAndAdd
    }
    return ""
}

fun main(args: Array<String>) {
    println(closeID("day2.txt".asResource()))
}

class IdHolder(input: String) {
    private val idPossibilities: MutableList<String> = mutableListOf(input)

    fun isCloseAndAdd(input: String):String?{
        val orNull = idPossibilities.mapNotNull { commonOnOne(input, it) }.getOrNull(0)
        idPossibilities.add(input)
        return orNull
    }

    private fun commonOnOne(input: String,model:String): String? {
        val common = StringBuilder(input.length)
        input.forEachIndexed { index, c ->
            if (model[index] == c) {
                common.append(c)
            }
        }
        return if (common.length == model.length - 1) common.toString() else null
    }
}