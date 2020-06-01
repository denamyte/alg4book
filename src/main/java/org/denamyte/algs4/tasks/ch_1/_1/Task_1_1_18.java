package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.denamyte.algs4.code.MysterySumAndMultiplication;

import java.util.Arrays;
import java.util.Collection;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.18.png" alt="Task screenshot">
 */
public class Task_1_1_18 {
    public static void main(String[] args) {
        Collection<AB> abs = Arrays.asList(new AB(2, 25), new AB(3, 11), new AB(5, 7));
        abs.forEach(ab -> {
            StdOut.printf("mystery(%d, %d): ", ab.a, ab.b);
            StdOut.printf("%d \n", MysterySumAndMultiplication.mystery(ab.a, ab.b));
        });
        StdOut.println("The mystery function with + signs multiplies a by b \n");
        abs.forEach(ab -> {
            StdOut.printf("mysteryMult(%d, %d): ", ab.a, ab.b);
            StdOut.printf("%d \n", MysterySumAndMultiplication.mysteryMult(ab.a, ab.b));
        });
        StdOut.println("The mystery function with * signs raises the number a to the power of b ");

    }

    @Data
    @AllArgsConstructor
    public static class AB {
        int a;
        int b;
    }

}
