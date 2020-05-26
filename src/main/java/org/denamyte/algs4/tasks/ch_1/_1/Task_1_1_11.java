package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;

/**
 * <img src="../../docs/Task.1.1.11.png" alt="Task screenshot">
 */
public class Task_1_1_11 {
    private static final boolean[][] array = {
            {true,  true, true,  true, true,  true, true,  true, true,  true, true,  true},
            {false, true, false, true, false, true, false, true, false, true, false, true},
            {true, false, true, false, true, false, true, false, true, false, true, false},
            {false, true, false, true, false, true, false, true, false, true, false, true},
            {true, false, true, false, true, false, true, false, true, false, true, false},
            {false, true, false, true, false, true, false, true, false, true, false, true},
            {true, false, true, false, true, false, true, false, true, false, true, false},
            {false, true, false, true, false, true, false, true, false, true, false, true},
            {true, false, true, false, true, false, true, false, true, false, true, false},
            {false, true, false, true, false, true, false, true, false, true, false, true},
            {true, false, true, false, true, false, true, false, true, false, true, false},
            {false, true, false, true, false, true, false, true, false, true, false, true}
    };

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        colNumbers(array[0].length, sb);
        for (int i = 0; i < array.length; i++) {
            row(i + 1, array[i], sb);
        }
        StdOut.print(sb.toString());
    }

    private static void colNumbers(int size, StringBuilder sb) {
        sb.append(" ");
        for (int i = 1; i <= size; i++) {
            sb.append(i % 10);
        }
        sb.append("\n");
    }

    private static void row(int rowNumber, boolean[] boolRow, StringBuilder sb) {
        sb.append(rowNumber % 10);
        for (boolean b : boolRow) {
            sb.append(b ? '*' : ' ');
        }
        sb.append("\n");
    }
}
