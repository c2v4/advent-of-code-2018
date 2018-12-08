package com.c2v4.advent18

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day7PlusTest{

    @Test
    internal fun graphmultipleWorkersTest() {
        Assertions.assertThat(graphmultipleWorkers("Step C must be finished before step A can begin.\n" +
            "Step C must be finished before step F can begin.\n" +
            "Step A must be finished before step B can begin.\n" +
            "Step A must be finished before step D can begin.\n" +
            "Step B must be finished before step E can begin.\n" +
            "Step D must be finished before step E can begin.\n" +
            "Step F must be finished before step E can begin.",2,0)).isEqualTo(15)
    }

}