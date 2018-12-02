package com.c2v4.advent18

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    internal fun checksumTest() {
        assertThat(
            checksum(
                """abcdef
bababc
abbcde
abcccd
aabcdd
abcdee
ababab"""
            )
        ).isEqualTo(12)
    }

    @Test
    internal fun exactlyTwiceTest() {
        assertThat(exactlyTwice("abad")).isTrue()
        assertThat(exactlyTwice("abadbgb")).isTrue()
        assertThat(exactlyTwice("abcd")).isFalse()
        assertThat(exactlyTwice("abaca")).isFalse()
    }


    @Test
    internal fun exactlyThreeTimesTest() {
        assertThat(exactlyThreeTimes("abada")).isTrue()
        assertThat(exactlyThreeTimes("abadbgb")).isTrue()
        assertThat(exactlyThreeTimes("abcd")).isFalse()
        assertThat(exactlyThreeTimes("abacaga")).isFalse()
    }
}