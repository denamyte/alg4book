package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;

/**
 * <img src="../../docs/Task.1.1.06.png" alt="Task screenshot">
 */
public class Task_1_1_06 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++)
        {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
        StdOut.println("obviously, the fibonacci numbers...");
    }
}
