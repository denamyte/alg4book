package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.denamyte.algs4.code.utils.Utils;

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
        private final int[] hist ;
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
            histogram = new Histogram(1024, 512);
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

    public static class Histogram {

        public static final double HIST_WINDOW_FRAME_LEFT = .1;
        public static final double HIST_WINDOW_FRAME_RIGHT = .9;
        public static final double HIST_WINDOW_FRAME_BOTTOM = .08;
        public static final double HIST_WINDOW_FRAME_TOP = .94;

        public static final Color HIST_BACKGROUND_COLOR = Color.LIGHT_GRAY;
        public static final Color HIST_WINDOW_COLOR = Color.WHITE;

        private final int width;
        private final int height;
        private final double halfWidth;
        private final double halfHeight;

        public Histogram(int width, int height) {
            this.width = width;
            this.height = height;
            halfWidth = width / 2.0;
            halfHeight = height / 2.0;
            setCanvasSizes(width, height);
            repaint();
        }

        public static void setCanvasSizes(int width, int height) {
            StdDraw.setCanvasSize(width, height);
        }

        public final void repaint() {
            drawBackgroundInit(halfWidth, halfHeight);
            drawHistWindowRect();
        }

        private void drawBackgroundInit(double hW, double hH) {
            StdDraw.setPenColor(HIST_BACKGROUND_COLOR);
            StdDraw.filledRectangle(.5, .5, .5, .5);
        }

        private void drawHistWindowRect() {
            StdDraw.setPenColor(HIST_WINDOW_COLOR);
            double halfWidth = calcHalfWidthBySideCrd(HIST_WINDOW_FRAME_LEFT, HIST_WINDOW_FRAME_RIGHT);
            //noinspection SuspiciousNameCombination
            double halfHeight = calcHalfWidthBySideCrd(HIST_WINDOW_FRAME_BOTTOM, HIST_WINDOW_FRAME_TOP);
            double centerX = HIST_WINDOW_FRAME_LEFT + halfWidth;
            double centerY = HIST_WINDOW_FRAME_BOTTOM + halfHeight;

            StdDraw.filledRectangle(centerX, centerY, halfWidth, halfHeight);
        }

//        private double calcRectCenterBySideCrd(double left, double right) {
//            return left + calcHalfWidthBySideCrd(left, right);
//        }

        private double calcHalfWidthBySideCrd(double left, double right) {
            return (right - left) / 2;
        }

    }


}
