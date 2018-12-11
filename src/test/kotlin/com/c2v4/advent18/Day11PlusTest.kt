package com.c2v4.advent18

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day11PlusTest {

    @Test
    internal fun mostPowerfulVariableTest() {
        Assertions.assertThat(mostPowerfulGridVariable(18)).isEqualTo("90,269,16")
        Assertions.assertThat(mostPowerfulGridVariable(42)).isEqualTo("232,251,12")
    }
}