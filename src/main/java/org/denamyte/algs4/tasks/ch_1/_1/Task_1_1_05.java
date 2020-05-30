package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.05.png" alt="Task screenshot">
 */
@SuppressWarnings("FieldCanBeLocal")
public class Task_1_1_05 {
    private static final double LOW = -0.5, HI = 1.5, LOW_BORDER = 0.0, HI_BORDER = 1.0;

    public static void main(String[] args) {
        int triesCount = 20;
        double[] vars = new double[2];
        StdRandom.setSeed(System.currentTimeMillis());
        for (int i = 0; i < triesCount; i++) {
            vars[0] = StdRandom.uniform(LOW, HI);
            vars[1] = StdRandom.uniform(LOW, HI);
            System.out.format("1st: %8.5f; 2nd: %8.5f; result: %b;\n", vars[0], vars[1]
                    , compare(vars));
        }
    }

    private static boolean compare(double[] vars) {
        return Arrays.stream(vars).allMatch(Task_1_1_05::compare);
    }

    private static boolean compare(double v) {
        return v > LOW_BORDER && v < HI_BORDER;
    }
}
