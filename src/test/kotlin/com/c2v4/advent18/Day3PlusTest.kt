package com.c2v4.advent18

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day3PlusTest{

    @Test
    internal fun overlappingFabricTest() {
        Assertions.assertThat(intactFabric("#1 @ 1,3: 4x4\n" +
            "#2 @ 3,1: 4x4\n" +
            "#3 @ 5,5: 2x2")).isEqualTo(3)
    }
}