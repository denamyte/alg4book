package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.13.png" alt="Task screenshot">
 */
public class Task_1_1_13 {

    private static final int
            ROW_COUNT = 5,
            COLUMN_COUNT = 10,
            MAX_VALUE = 1000;
    private static final int[][] ARRAY = new int[ROW_COUNT][COLUMN_COUNT];

    static {
        StdRandom.setSeed(System.currentTimeMillis());
        for (int row = 0; row < ROW_COUNT; row++)
            for (int column = 0; column < COLUMN_COUNT; column++)
                ARRAY[row][column] = StdRandom.uniform(MAX_VALUE);
    }

    public static void main(String[] args) {
        StdOut.println("Printing normally:");
        printNormal(ARRAY, ROW_COUNT, COLUMN_COUNT);
        StdOut.println("\nPrinting after transposition:");
        printTransposition(ARRAY, ROW_COUNT, COLUMN_COUNT);
    }

    @SuppressWarnings("SameParameterValue")
    private static void printNormal(int[][] array, int rowCount, int colCount) {
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < colCount; column++) {
                StdOut.printf("%4d", array[row][column]);
            }
            StdOut.print('\n');
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static void printTransposition(int[][] array, int rowCount, int colCount) {
        for (int column = 0; column < colCount; column++) {
            for (int row = 0; row < rowCount; row++) {
                StdOut.printf("%4d", array[row][column]);
            }
            StdOut.print('\n');
        }
    }
}
