package com.c2v4.advent18

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day11Test {

    @Test
    internal fun cellPowerTest() {
        Assertions.assertThat(cellPower(3, 5, 8)).isEqualTo(4)
        Assertions.assertThat(cellPower(122, 79, 57)).isEqualTo(-5)
        Assertions.assertThat(cellPower(217, 196, 39)).isEqualTo(0)
        Assertions.assertThat(cellPower(101, 153, 71)).isEqualTo(4)
    }

    @Test
    internal fun mostPowerfulTest() {
        Assertions.assertThat(mostPowerfullGrid(18)).isEqualTo("33,45")
        Assertions.assertThat(mostPowerfullGrid(42)).isEqualTo("21,61")
    }
}