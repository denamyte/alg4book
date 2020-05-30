package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.13.png" alt="Task screenshot">
 */
public class Task_1_1_13 {

    private static final int ROWS_COUNT = 5, COLUMNS_COUNT = 10;
    private static final int[][] ARRAY = new int[ROWS_COUNT][COLUMNS_COUNT];

    static {
        StdRandom.setSeed(System.currentTimeMillis());
        for (int row = 0; row < ROWS_COUNT; row++)
            for (int column = 0; column < COLUMNS_COUNT; column++)
                ARRAY[row][column] = StdRandom.uniform(1000);
    }

    public static void main(String[] args) {
        StdOut.println("Printing normally:");
        printNormal(ARRAY, ROWS_COUNT, COLUMNS_COUNT);
        StdOut.println("\nPrinting after transposition:");
        printTransposition(ARRAY, ROWS_COUNT, COLUMNS_COUNT);
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
