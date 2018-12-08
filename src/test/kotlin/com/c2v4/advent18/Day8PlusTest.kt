package com.c2v4.advent18

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day8PlusTest{

    @Test
    internal fun licenseMetaTest() {
        Assertions.assertThat(licenseMeta("2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2")).isEqualTo(66)
        Assertions.assertThat(licenseMeta("2 3 1 1 0 1 99 2 0 3 10 11 12 1 1 2")).isEqualTo(33)
    }

}