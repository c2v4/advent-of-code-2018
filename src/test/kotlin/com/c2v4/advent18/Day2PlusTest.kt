package com.c2v4.advent18

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2PlusTest{
    @Test
    internal fun closeIdTest() {
        assertThat(closeID("abcde\n" +
            "fghij\n" +
            "klmno\n" +
            "pqrst\n" +
            "fguij\n" +
            "axcye\n" +
            "wvxyz")).isEqualTo("fgij")
    }
}