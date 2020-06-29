package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.apache.commons.lang3.ArrayUtils;
import org.denamyte.algs4.code.common.utils.Utils;

import java.util.Arrays;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.15.png" alt="Task screenshot">
 */
public class Task_1_1_15 {

    private static final int LENGTH = 20, LO = 0, HI = 10, HIST_LENGTH = 10, COUNT = 5;

    public static void main(String[] args) {
        StdRandom.setSeed(System.currentTimeMillis());
        for (int i = 0; i < COUNT; i++) {
            int[] array = Utils.createIntArraySorted(LENGTH, LO, HI);
            int[] histogram = histogram(array, HIST_LENGTH);
            printHist(array, histogram);
        }
    }

    private static void printHist(int[] a, int[] hist) {
        StdOut.println("Array: " + Arrays.toString(a));
        StdOut.println("Histogram: ");
        for (int i = 0; i < hist.length; i++) {
            StdOut.printf("hist[%2d]=%d\n", i, hist[i]);
        }
        StdOut.println();
    }

    /**
     * @param a An array containing some integer values
     * @param m The upper border in a range [0..m]
     * @return an array of length <b><i>m</i></b> whose <b><i>i</i></b>th entry is the number
     * of times the integer <b><i>i</i></b> appeared in the argument array
     */
    private static int[] histogram(int[] a, int m) {
        if (ArrayUtils.getLength(a) == 0 || m <= 0) {
            throw new IllegalArgumentException("either the array a has zero length or the variable m <= 0");
        }
        int[] hist = new int[m];
        for (int i = 0; i < m; i++) {
            int ii = i;
            hist[i] = (int) Arrays.stream(a).filter(value -> value == ii).count();
        }
        return hist;
    }
}
