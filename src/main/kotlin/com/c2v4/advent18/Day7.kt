package com.c2v4.advent18

import com.google.common.graph.GraphBuilder
import com.google.common.graph.MutableGraph
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.atan2

fun graphAlpabetically(input: String): String =
    input.split(splitRegex).fold(GraphBuilder.directed().build<Char>()) { acc, s ->
        acc.putEdge(s.elementAt(5), s.elementAt(36))
        acc
    }.let { graph ->
        val currentNodes = findStartNodes(graph).toMutableSet()
        val result = StringBuilder()
        while (currentNodes.isNotEmpty()){
            val minimal = currentNodes.minBy { it }
            result.append(minimal)
            currentNodes.remove(minimal)
            currentNodes.addAll(graph.successors(minimal).filter { graph.predecessors(it).all { result.contains(it) } })
        }
        result.toString()
    }

fun findStartNodes(graph: MutableGraph<Char>): Set<Char> =
    graph.edges().filter { graph.predecessors(it.source()).isEmpty() }.map { it.source() }.toSet()


fun main(args: Array<String>) {
    println(graphAlpabetically("day7.txt".asResource()))
}
