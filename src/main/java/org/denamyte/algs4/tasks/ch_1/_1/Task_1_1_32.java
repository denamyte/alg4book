package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.denamyte.algs4.code.common.Rect;
import org.denamyte.algs4.code.histogram.HistParams;
import org.denamyte.algs4.code.histogram.Histogram;
import org.denamyte.algs4.code.common.utils.Utils;

import java.awt.*;
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
        private final int[] hist;
        private final Histogram histogram;

        /**
         * @param n The amount of equal sized intervals.
         * @param l The lower bound of the intervals.
         * @param r The upper bound of the intervals.
         */
        public HistogramDoubleFrequencies(int n, double l, double r) {
            this.n = n;
            Utils.checkDouble(l, null, r);
            this.l = l;
            this.r = r;
            diff = r - l;
            hist = new int[n];
            double width = 1024 + 256, height = 512 + 256;
            double histFrameX = 1 / 12.0 * width;
            double histFrameY = 1 / 10.0 * width;
            histogram = new Histogram(
                    new HistParams()
                            .setScrWidth(width)
                            .setScrHeight(height)
                            .setBgrColor(new Color(220, 220, 220))

                            .setMainAreaRect(new Rect(
                                    histFrameX, //.06 * width,
                                    histFrameY, //.13 * height,
                                    width - histFrameX - 50,
                                    height - histFrameY - 40))
                            .setMainAreaBgrColor(Color.WHITE)
                            .setMainAreaBorderWidth(10)
                            .setMainAreaBorderColor(Color.GRAY)

                            .setCaptionColor(new Color(120, 120, 50))
                            .setCaptionText("Frequency Histogram (Algorithms, 4-th ed., p. 60, Task 1.1.32")
            );
        }

        public void acceptNextValue(double value) {
            if (value >= l && value <= r) {
                int index = calcValueIndex(value);
                if (index >= 0 && index < n) {
                    hist[index]++;
                }
            }
            StdOut.println(Arrays.toString(hist));
            histogram.repaint();
        }

        private int calcValueIndex(double value) {
            return (int) ((value - l) / diff * n);
        }
    }
    // TODO: 6/27/20 Create 4 classes-descendants of HistArea:
    //  MainArea

}
