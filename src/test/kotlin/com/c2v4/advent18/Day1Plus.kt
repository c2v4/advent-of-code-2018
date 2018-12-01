package com.c2v4.advent18

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day1PlusTest{

    @Test
    internal fun zeroTest() {
        Assertions.assertThat(repeatedFrequency("+1\n-1")).isEqualTo(0)
    }

    @Test
    internal fun tenTest() {
        Assertions.assertThat(repeatedFrequency("+3\n+3\n+4\n-2\n-4")).isEqualTo(10)
    }

    @Test
    internal fun fiveTest() {
        Assertions.assertThat(repeatedFrequency("-6\n+3\n+8\n+5\n-6")).isEqualTo(5)
    }

    @Test
    internal fun fourteenTest() {
        Assertions.assertThat(repeatedFrequency("+7\n+7\n-2\n-7\n-4")).isEqualTo(14)
    }
}