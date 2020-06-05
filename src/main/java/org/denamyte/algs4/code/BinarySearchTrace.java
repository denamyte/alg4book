package org.denamyte.algs4.code;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.apache.commons.lang3.StringUtils;
import org.denamyte.algs4.tasks.ch_1._1.Task_1_1_22;

public class BinarySearchTrace {

    public static void startSearch(int[] array, int lo, int hi) {
        StdRandom.setSeed(System.currentTimeMillis());
        for (int i = 0; i < Task_1_1_22.SEARCH_COUNT; i++) {
            int toFind = StdRandom.uniform(lo, hi);
            StdOut.printf("Integer range: [%d..%d); looking for: %d\n", lo, hi, toFind);
            StdOut.printf("Found = %d\n\n", rank(toFind, array));
        }
    }

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 1);
    }

    public static int rank(int key, int[] a, int lo, int hi, int depth) {
        printDepth(lo, hi, depth);
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
            return rank(key, a, lo, mid - 1, depth + 1);
        else if (key > a[mid])
            return rank(key, a, mid + 1, hi, depth + 1);
        else
            return mid;
    }

    public static void printDepth(int lo, int hi, int depth) {
        String indent = StringUtils.repeat(' ', depth);
        StdOut.printf("%slo: %d; hi: %d\n", indent, lo, hi);
    }
}
