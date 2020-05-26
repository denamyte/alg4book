package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;

/**
 * <img src="../../docs/Task.1.1.07.png" alt="Task screenshot">
 */
public class Task_1_1_07 {
    public static void main(String[] args) {
        a();
        b();
        c();
    }

    private static void a() {  // Searching for the square root of 9
        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .001)
        t = (9.0/t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
    }

    private static void b() {  // 500 * 999
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
    }

    private static void c() {  // i = 1 2 4 8 16 32 64 128 256 512; sum = 2^10 - 1
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
    }
}
