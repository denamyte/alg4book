package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.03.png" alt="Task screenshot">
 */
public class Task_1_1_03 {
    public static void main(String[] args) {
        if (args.length != 3)
            throw new IllegalArgumentException();
        int[] a = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = Integer.parseInt(args[i]);
        }
        StdOut.println(Arrays.toString(a));
        for (int i = 1; i < 3; i++) {
            if (a[i] != a[i - 1]) {
                StdOut.printf("not equal\n%d != %d", a[i - 1], a[i]);
                return;
            }
        }
        StdOut.print("equal");
    }
}
