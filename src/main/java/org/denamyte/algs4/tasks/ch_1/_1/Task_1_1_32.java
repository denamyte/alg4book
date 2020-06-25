package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.denamyte.algs4.code.utils.Utils;

import java.util.Arrays;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.32.png" alt="Task screenshot">
 */
public class Task_1_1_32 {
    public static void main(String[] args) {
        Utils.checkArgsLength(args.length, 3);
        int n = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);

        HistogramDoubleFrequencies hdf = new HistogramDoubleFrequencies(n, l, r);
        String invite = String.format("Enter next double in the interval (%f, %f)", l, r);
        while (Utils.stdInInviteAndCheck(invite)) {
            double value = StdIn.readDouble();
            hdf.acceptNextValue(value);
        }

    }

    public static class HistogramDoubleFrequencies {
        private final int n;
        private final double l;
        private final double r;
        private final double diff;
        //         <interval#, hit count>
        private final int[] hist ;

        public HistogramDoubleFrequencies(int n, double l, double r) {
            this.n = n;
            Utils.checkDouble(l, null, r);
            this.l = l;
            this.r = r;
            diff = r - l;
            hist = new int[n];
        }

        public void acceptNextValue(double value) {
            if (value >= l && value <= r) {
                int index = calcValueIndex(value);
                if (index >= 0 && index < n) {
                    hist[index]++;
                }
            }
            StdOut.println(Arrays.toString(hist));
        }

        private int calcValueIndex(double value) {
            return (int) ((value - l) / diff * n);
        }

    }

}
