package com.c2v4.advent18

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day9Test {

    @Test
    internal fun marbleGameTest1() {
        Assertions.assertThat(marbleGame("9 players; last marble is worth 25 points")).isEqualTo(32)
    }

    @Test
    internal fun marbleGameTest2() {
        Assertions.assertThat(marbleGame("10 players; last marble is worth 1618 points")).isEqualTo(8317)
    }

    @Test
    internal fun marbleGameTest3() {
        Assertions.assertThat(marbleGame("13 players; last marble is worth 7999 points")).isEqualTo(146373)
    }

    @Test
    internal fun marbleGameTest4() {
        Assertions.assertThat(marbleGame("17 players; last marble is worth 1104 points")).isEqualTo(2764)
    }

    @Test
    internal fun marbleGameTest5() {
        Assertions.assertThat(marbleGame("21 players; last marble is worth 6111 points")).isEqualTo(54718)
    }

    @Test
    internal fun marbleGameTest6() {
        Assertions.assertThat(marbleGame("30 players; last marble is worth 5807 points")).isEqualTo(37305)
    }
}