package org.denamyte.algs4.tasks.ch_1._1;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.12.png" alt="Task screenshot">
 */
public class Task_1_1_12 {
    public static void main(String[] args) {
        task();
    }

    private static void task() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            System.out.println(i);
    }
}
