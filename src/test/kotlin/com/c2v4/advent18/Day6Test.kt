package com.c2v4.advent18

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day6Test{

    @Test
    internal fun aATest() {
        Assertions.assertThat(safeArea("1, 1\n" +
            "1, 6\n" +
            "8, 3\n" +
            "3, 4\n" +
            "5, 5\n" +
            "8, 9")).isEqualTo(17)
    }

}