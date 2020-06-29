package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdRandom;
import org.denamyte.algs4.code.BinarySearchNoDuplicates;
import org.denamyte.algs4.code.common.utils.Utils;

import java.util.Arrays;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.28.png" alt="Task screenshot">
 */
public class Task_1_1_28 {

    public static final int LO = 0, HI = 20, LENGTH = 20, COUNT = 10;

    public static void main(String[] args) {
        StdRandom.setSeed(System.currentTimeMillis());
        for (int i = 0; i < COUNT; i++) {
            int[] array = Utils.createIntArraySorted(LO, HI, LENGTH);
            int[] noDup = BinarySearchNoDuplicates.removeDuplicates(array);
            System.out.printf("Try #:%2d\n", i + 1);
            System.out.printf("Before sort: %s\n", Arrays.toString(array));
            System.out.printf(" After sort: %s\n\n", Arrays.toString(noDup));
        }
    }

}
