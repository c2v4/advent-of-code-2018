package com.c2v4.advent18

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day5PlusTest{
    @Test
    internal fun dabAcCaCBAcCcaDATest() {
        Assertions.assertThat(polymerRemove("dabAcCaCBAcCcaDA")).isEqualTo(4)
    }
}