package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;

import java.util.stream.Stream;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.16.png" alt="Task screenshot">
 */
public class Task_1_1_16 {
    public static void main(String[] args) {
        Stream.of(21, 16, 6).forEach(i -> {
            StdOut.printf("exR1(%d):\n", i);
            StdOut.println(exR1(i));
            StdOut.println();
        });
    }

    public static String exR1(int n) {
        if (n <= 0)
            return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }
}

/*
exR1(6): "3113" + 6 + "114224" + 6 = "311361142246"
exR1(4): "11" + 4 + "22" + 4 = "114224"
exR1(3): "" + 3 + "11" + 3 = "3113"
exR1(2): "" + 2 + "" + 2 = "22"
exR1(1): "" + 1 + "" + 1 = "11"
exR1(0), exR1(-2), exR1(-1): ""

 */
