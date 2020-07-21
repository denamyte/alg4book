package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.denamyte.algs4.code.common.Rect;
import org.denamyte.algs4.code.histogram.ColumnSettings;
import org.denamyte.algs4.code.histogram.HistData;
import org.denamyte.algs4.code.histogram.HistParams;
import org.denamyte.algs4.code.histogram.Histogram;
import org.denamyte.algs4.code.common.utils.Utils;

import java.awt.*;
import java.util.ArrayList;
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
                    HistParams.builder()
                            .scrWidth(width)
                            .scrHeight(height)
                            .bgrColor(new Color(220, 220, 220))

                            .mainAreaRect(new Rect(
                                    histFrameX, //.06 * width,
                                    histFrameY, //.13 * height,
                                    width - histFrameX - 50,
                                    height - histFrameY - 40))
                            .mainAreaBgrColor(Color.WHITE)
                            .mainAreaBorderWidth(4)
                            .mainAreaBorderColor(Color.GRAY)
                            .drawHorzLinesInMainArea(true)

                            .captionColor(new Color(120, 120, 50))
                            .captionText("Frequency Histogram (Algorithms, 4-th ed., p. 60, Task 1.1.32")

                            .columnSettings(
                                    ColumnSettings.builder()
                                            .paddingSide(.3)
                                            .paddingBetween(.3)
                                            .barColor(Color.BLACK)
                                            .borders(true)
                                            .borderSizeRelative(true)
                                            .borderSize(.1)
                                            .build()
                            )
                            .build(),
                    new HistData(new ArrayList<>(
                            Arrays.asList(
                                    new HistData.HistUnit("value 1", 1),
                                    new HistData.HistUnit("value 2", 12),
                                    new HistData.HistUnit("value 3", 5)
                            )))
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
            // TODO: 7/21/20 Create a new HistData.HistUnit from hist[], pass this data to the histogram.
//            histogram.repaint();
        }

        private int calcValueIndex(double value) {
            return (int) ((value - l) / diff * n);
        }
    }
    // TODO: 6/27/20 Create 4 classes-descendants of HistArea:
    //  MainArea

}
