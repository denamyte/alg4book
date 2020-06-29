package org.denamyte.algs4.code.common.utils;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
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

    public static void checkArgsLength(int actual, int estimated) {
        if (actual != estimated) {
            throw new IllegalArgumentException(
                    String.format("The actual arguments' length (%d) is not equal to the estimated one (%d)",
                                  actual, estimated));
        }
    }

    public static int checkInt(int a, Integer gte, Integer lte) {
        if (gte != null && a < gte) {
            throw new IllegalArgumentException(String.format("The value (actual = %d) should be greater than or equal to %d", a, gte));
        }
        if (lte != null && a > lte) {
            throw new IllegalArgumentException(String.format("The value (actual = %d) should be less than or equal to %d", a, lte));
        }
        return a;
    }

    public static double checkDouble(double a, Double gte, Double lte) {
        if (gte != null && a < gte) {
            throw new IllegalArgumentException(String.format("The value (actual = %f) should be greater than or equal to %f", a, gte));
        }
        if (lte != null && a > lte) {
            throw new IllegalArgumentException(String.format("The value (actual = %f) should be less than or equal to %f", a, lte));
        }
        return a;
    }

    /**
     * Use this method in a while operator when you expect users to successively input values
     * @param invite A text to print in the console to invite users to enter a value.
     * @return A flag that means the input stream is not empty.
     */
    public static boolean stdInInviteAndCheck(String invite) {
        StdOut.println(invite);
        return !StdIn.isEmpty();
    }
}
