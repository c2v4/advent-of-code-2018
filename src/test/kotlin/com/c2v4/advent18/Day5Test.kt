package com.c2v4.advent18

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day5Test{

    @Test
    internal fun aATest() {
        Assertions.assertThat(polymerReduction("aA")).isEqualTo(0)
    }

    @Test
    internal fun abBATest() {
        Assertions.assertThat(polymerReduction("abBA")).isEqualTo(0)
    }

    @Test
    internal fun abABTest() {
        Assertions.assertThat(polymerReduction("abAB")).isEqualTo(4)
    }

    @Test
    internal fun aabAABTest() {
        Assertions.assertThat(polymerReduction("aabAAB")).isEqualTo(6)
    }

    @Test
    internal fun dabAcCaCBAcCcaDATest() {
        Assertions.assertThat(polymerReduction("dabAcCaCBAcCcaDA")).isEqualTo(10)
    }
}