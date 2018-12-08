package com.c2v4.advent18

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day8Test{

    @Test
    internal fun licenseTest() {
        Assertions.assertThat(license("2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2")).isEqualTo(138)
        Assertions.assertThat(license("2 3 1 1 0 1 99 2 0 3 10 11 12 1 1 2")).isEqualTo(138)
    }

}