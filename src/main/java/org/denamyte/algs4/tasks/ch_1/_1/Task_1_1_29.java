package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdRandom;
import org.denamyte.algs4.code.utils.Utils;

import java.util.Arrays;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.29.png" alt="Task screenshot">
 */
public class Task_1_1_29 {

    public static final int LO = 0, HI = 20, LENGTH = 20, COUNT = 10;

    public static void main(String[] args) {
        for (int i = 0; i < COUNT; i++) {
            int[] array = Utils.createIntArraySorted(LO, HI, LENGTH);
            int key = StdRandom.uniform(LO, HI);
            int lessThan = rankLessThan(key, array);
            int eq = countEquals(key, array, lessThan);
            System.out.printf("Array: %s\n", Arrays.toString(array));
            System.out.printf("Key  : %d\n", key);
            System.out.printf("Less than the key count: %d\n", lessThan);
            System.out.printf("Equal to the key count : %d\n\n", eq);
        }
    }

    public static int rankLessThan(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key <= a[mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return lo;
    }

    public static int countEquals(int key, int[] a) {
        return countEquals(key, a, rankLessThan(key, a));
    }

    public static int countEquals(int key, int[] a, int nextIndex) {
        int count = 0;
        while (nextIndex < a.length && a[nextIndex++] == key)
            count++;
        return count;
    }

}
