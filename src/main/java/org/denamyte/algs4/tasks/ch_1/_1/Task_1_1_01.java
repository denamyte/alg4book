package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;

/**
 * <img src="../../docs/img/Task.1.1.01.png" alt="Task screenshot">
 */
public class Task_1_1_01 {
    public static void main(String[] args) {
        StdOut.printf("%-32s: %d\n", "(0 + 15) / 2", first());
        StdOut.printf("%-32s: %f\n", "2.0e-6 * 100000000.1", second());
        StdOut.printf("%-32s: %b\n", "true && false || true && true", third());
    }

    @SuppressWarnings("PointlessArithmeticExpression")
    private static int first() {
        return (0 + 15) / 2;
    }

    private static double second() {
        return 2.0e-6 * 100000000.1;
    }

    @SuppressWarnings("PointlessBooleanExpression, ConstantConditions")
    private static boolean third() {
        return true && false || true && true;
    }
}
