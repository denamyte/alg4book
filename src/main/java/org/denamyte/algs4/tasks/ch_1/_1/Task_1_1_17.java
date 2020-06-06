package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.17.png" alt="Task screenshot">
 */
public class Task_1_1_17 {
    public static void main(String[] args) {
        // no coding solution
        StdOut.println(exR2(6));
    }

    public static String exR2(int n) {
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        if (n <= 0)
            return "";
        return s;
    }

}
