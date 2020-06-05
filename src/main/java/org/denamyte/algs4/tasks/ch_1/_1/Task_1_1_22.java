package org.denamyte.algs4.tasks.ch_1._1;

import org.denamyte.algs4.code.BinarySearchTrace;

import java.util.stream.IntStream;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.22.png" alt="Task screenshot">
 */
public class Task_1_1_22 {

    public static final int LO = 0, HI = 5001, SEARCH_COUNT = 5;

    public static void main(String[] args) {
        BinarySearchTrace.startSearch(IntStream.range(LO, HI).toArray(), LO, HI, SEARCH_COUNT);
    }
}
