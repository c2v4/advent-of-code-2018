package com.c2v4.advent18

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun sleepyFrequentGuard(input: String): Any = input.split(splitRegex).map {
    val split = it.split("] ")
    GuardEntry(
        LocalDateTime.from(dateTimeFormatter.parse(split[0])),
        when (split[1].substring(0..4)) {
            "falls" -> GuardAction.SLEEP
            "wakes" -> GuardAction.WAKE
            "Guard" -> GuardAction.CHANGE
            else -> {
                throw IllegalArgumentException()
            }
        }, numberRegex.find(split[1])?.value?.toInt() ?: -1
    )

}.sortedBy { it.time }
    .fold(
        mutableListOf<GuardSleepingHours>() to GuardEntry(
            LocalDateTime.MIN,
            GuardAction.CHANGE,
            -1
        )
    ) { (acc: MutableList<GuardSleepingHours>, previousEntry), guardEntry: GuardEntry ->
        if (guardEntry.action == GuardAction.WAKE) {
            var find = acc.find { previousEntry.id == it.id }
            if (find == null) {
                find = GuardSleepingHours(previousEntry.id, mutableListOf())
                acc.add(find)
            }
            find!!.sleepingEvents.add(
                DayMonth(
                    guardEntry.time.dayOfMonth,
                    guardEntry.time.monthValue
                ) to (previousEntry.time.minute until guardEntry.time.minute)
            )
        }
        acc to if (guardEntry.id == -1) guardEntry.copy(id = previousEntry.id) else guardEntry
    }.first
    .let {
        it.map {
            val initial = IntArray(60)
            it.sleepingEvents.map { it.second }.forEach { it.forEach { initial[it]++ } }
            it to initial
        }.maxBy { it.second.max() ?: -1 }?.let { it.first.id * it.second.indexOf(it.second.max() ?: -1) } ?: -1
    }

fun main(args: Array<String>) {
    println(sleepyFrequentGuard("day4.txt".asResource()))
}
