package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.denamyte.algs4.code.Histogram;

import java.util.Arrays;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.15.png" alt="Task screenshot">
 */
public class Task_1_1_15 {

    private static final int LENGTH = 20, LO = 0, HI = 10, HIST_LENGTH = 10, COUNT = 5;

    public static void main(String[] args) {
        StdRandom.setSeed(System.currentTimeMillis());
        for (int i = 0; i < COUNT; i++) {
            int[] array = prepareArray(LENGTH, LO, HI);
            int[] histogram = Histogram.histogram(array, HIST_LENGTH);
            printHist(array, histogram);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static int[] prepareArray(int length, int lo, int hi) {
        if (length <= 0) {
            throw new IllegalArgumentException("The array length must be > 0");
        }
        if (lo < 0) {
            throw new IllegalArgumentException("lo and hi must be >= 0");
        }
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = StdRandom.uniform(lo, hi);
        }
        Arrays.sort(a);
        return a;
    }

    private static void printHist(int[] a, int[] hist) {
        StdOut.println("Array: " + Arrays.toString(a));
        StdOut.println("Histogram: ");
        for (int i = 0; i < hist.length; i++) {
            StdOut.printf("hist[%2d]=%d\n", i, hist[i]);
        }
        StdOut.println();
    }

}
