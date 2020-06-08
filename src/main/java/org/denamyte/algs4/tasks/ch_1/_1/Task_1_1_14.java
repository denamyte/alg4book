package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;

import java.util.stream.Stream;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.14.png" alt="Task screenshot">
 */
public class Task_1_1_14 {

    private static final int base = 2;
    public static void main(String[] args) {
        Stream.of(
                Math.pow(2, 4) - 1,     // result = 3
                Math.pow(2, 4) + 1,     // result = 4
                Math.pow(2, 8) - 1,     // result = 7
                Math.pow(2, 8) + 1,     // result = 8
                Math.pow(2, 8),         // result = 8
                Math.pow(2, 11) - 1,    // result = 10
                Math.pow(2, 11) + 1,    // result = 11 ??
                Math.pow(2, 25) - 1,    // result = 24
                Math.pow(2, 25) + 1,    // result = 25
                Math.pow(2, 28) - 1,    // result = 27
                Math.pow(2, 28),        // result = 28
                Math.pow(2, 28) + 1     // result = 28
        )
                .map(Double::intValue)
                .forEach(i -> print(base, i, lg(i)));
    }

    /**
     * Returns the largest int not larger than the base-2 logarithm of N.
     * @param n The argument to the logarithm
     * @return The largest int
     */
    public static int lg(int n) {
        return lg2(base, n, 0, 31);
    }

    public static int lg2(int logBase, int n, int lo, int hi) {
        if (hi - lo <= 1) return lo;
        int mid = (lo + hi) / 2;
        int elevated = logBase << mid - 1;
        if (elevated > n) {
            return lg2(logBase, n, lo, mid);
        }
        if (elevated < n) {
            return lg2(logBase, n, mid, hi);
        }
        return mid;
    }

    private static void print(int base, int n, int result) {
        StdOut.printf("N: %10d; Log2: %13.10f; Result: %d \n", n, Math.log10(n) / Math.log10(base), result);
    }
}
