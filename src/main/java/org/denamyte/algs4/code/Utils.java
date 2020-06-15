package org.denamyte.algs4.code;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Utils {
    public static int[] createIntArray(int lo, int hi, int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The array length must be > 0");
        }
        if (lo < 0) {
            throw new IllegalArgumentException("lo and hi must be >= 0");
        }
        int[] array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = StdRandom.uniform(lo, hi);
        return array;
    }

    public static int[] createIntArraySorted(int lo, int hi, int length) {
        int[] array = createIntArray(lo, hi, length);
        Arrays.sort(array);
        return array;
    }
}
