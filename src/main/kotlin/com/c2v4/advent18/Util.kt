package com.c2v4.advent18

fun String.asResource() = Thread.currentThread().contextClassLoader.getResource(this).readText()

val splitRegex = Regex("\\r?\\n")