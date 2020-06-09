package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Collection;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.26.png" alt="Task screenshot">
 */
public class Task_1_1_26 {

    private static Collection<Params> inputs = Arrays.asList(
            new Params(1, 2, 3),
            new Params(1, 3, 2),
            new Params(3, 1, 2),
            new Params(3, 2, 1),
            new Params(2, 1, 3),
            new Params(2, 3, 1));

    public static void main(String[] args) {
        inputs.forEach(input -> {
            printf("input", input);
            Params output = sort(input);
            printf("output", output);
            StdOut.println();
        });
    }

    private static Params sort(Params input) {
        int a = input.a, b = input.b, c = input.c, t;
        if (a > b) { t = a; a = b; b = t; }
        if (a > c) { t = a; a = c; c = t; }
        if (b > c) { t = b; b = c; c = t; }
        return new Params(a, b, c);
    }

    private static void printf(String type, Params params) {
        StdOut.printf("%6s: a = %d, b = %d, c = %d\n", type, params.a, params.b, params.c);
    }

    @AllArgsConstructor
    private static class Params {
        int a, b, c;
    }

}
