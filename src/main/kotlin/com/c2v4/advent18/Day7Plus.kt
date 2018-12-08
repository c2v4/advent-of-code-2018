package com.c2v4.advent18

import com.google.common.graph.GraphBuilder

fun graphmultipleWorkers(input: String, workers: Int, overhead: Int): Int =
    input.split(splitRegex).fold(GraphBuilder.directed().build<Char>()) { acc, s ->
        acc.putEdge(s.elementAt(5), s.elementAt(36))
        acc
    }.let { graph ->
        val openNodes = findStartNodes(graph).map { it to it - 'A' + 1 + overhead }.toMutableSet()
        val done = mutableSetOf<Char>()
        val workersDoing = Array(workers) { '0' }
        var time = 0
        while (openNodes.isNotEmpty() || workersDoing.filterNot { it == '0' }.isNotEmpty()) {
            val minimal = openNodes.filterNot { workersDoing.contains(it.first) }.sortedBy { it.first }
                .take(workersDoing.filter { it == '0' }.size)
            minimal.forEachIndexed { index, i -> workersDoing[workersDoing.indexOfFirst { it == '0' }] = i.first }
            val inProgress =
                workersDoing.map { char -> openNodes.filter { it.first == char }.getOrNull(0) }.filterNotNull()
            val firstToFinish = inProgress.minBy { it.second }!!
            workersDoing[workersDoing.indexOfFirst { it == firstToFinish.first }] = '0'
            openNodes.remove(firstToFinish)
            done.add(firstToFinish.first)
            inProgress.minus(firstToFinish).forEach { atWork ->
                val toModify = openNodes.filter { it.first == atWork.first }.first()
                val previousTime = toModify.second
                openNodes.remove(toModify)
                openNodes.add(toModify.first to previousTime - firstToFinish.second)
            }
            time += firstToFinish.second
            openNodes.addAll(graph.successors(firstToFinish.first).filterNot {
                done.contains(it) || openNodes.map { it.first }.contains(it) || !graph.predecessors(it).all { done.contains(it) }
            }.map { it to it - 'A' + 1 + overhead })

        }
        time
    }

fun main(args: Array<String>) {
    println(graphmultipleWorkers("day7.txt".asResource(), 5, 60))
}
