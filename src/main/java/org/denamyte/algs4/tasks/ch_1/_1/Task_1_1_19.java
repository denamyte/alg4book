package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.19-1.png" alt="Task screenshot"><br>
 * <img src="../../docs/ch_1/_1/Task.1.1.19-2.png" alt="Task screenshot">
 */
public class Task_1_1_19 {

//    public static void main(String[] args) {
//        for (int N = 0; N < 100; N++)
//            StdOut.println(N + " " + F(N));
//    }
//
//    public static long F(int N) {
//        if (N <= 1)
//            return N;
//        return F(N - 1) + F(N - 2);
//    }

    public static void main(String[] args) {
        new FChanged(90);
    }

    public static class FChanged {

        private final int max;
        private final long[] cache;

        FChanged(int max) {
            if (max <= 2)
                throw new IllegalArgumentException();
            this.max = max;
            cache = new long[max];
            Arrays.fill(cache, -1);
            launch();
        }

        void launch() {
            for (int n = 0; n < max; n++)
                StdOut.println(n + " " + cacheOrCalc(n));
        }

        long calc(int n) {
            if (n <= 1)
                return n;
            return cacheOrCalc(n - 1) + cacheOrCalc(n - 2);
        }

        long cacheOrCalc(int n) {
            long res = cache[n];
            return res == -1 ? calcAndCache(n) : res;
        }

        long calcAndCache(int n) {
            cache[n] = calc(n);
            return cache[n];
        }
    }

}
