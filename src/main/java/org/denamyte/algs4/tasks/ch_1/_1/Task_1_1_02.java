package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;

/**
 * <img src="../../docs/Task.1.1.02.png" alt="Task screenshot">
 */
public class Task_1_1_02 {

    public static final String A = "(1 + 2.236) / 2";
    public static final String B = "1 + 2 + 3 + 4.0";
    public static final String C = "4.1 >= 4";
    public static final String D = "1 + 2 + \"3\"";

    public static void main(String[] args) {
        double a = (1 + 2.236) / 2;
        double b = 1 + 2 + 3 + 4.0;
        //noinspection ConstantConditions
        boolean c = 4.1 >= 4;
        String d = 1 + 2 + "3";

        print(A, a + "", "double");
        print(B, b + "", "double");
        print(C, c + "", "boolean");
        print(D, d + "", "String");
    }

    public static void print(String expr, String value, String type) {
        StdOut.printf("Expr: %-15s = %5s; type: %s\n", expr, value, type);
    }
}
