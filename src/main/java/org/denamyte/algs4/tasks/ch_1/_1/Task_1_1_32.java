package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.denamyte.algs4.code.utils.Utils;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
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

    public static StdRectParams calcStdRectParam(Rectangle2D.Double rect, double borderWidth,
                                                 double xFactor, double yFactor) {
        double stdHalfW = xFactor * ((rect.getWidth() - borderWidth) / 2);
        double stdHalfH = yFactor * ((rect.getHeight() - borderWidth) / 2);
        double stdCenterX = stdHalfW + xFactor * (rect.getX() + borderWidth / 2);
        double stdCenterY = stdHalfH + yFactor * (rect.getY() + borderWidth / 2);
        return new StdRectParams(stdCenterX, stdCenterY, stdHalfW, stdHalfH);
    }

    public static double toStdPen(double radius) {
        return radius / 512;
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
            double width = 1024, height = 512;
            histogram = new Histogram(
                    new HistParams()
                            .setWidth(width)
                            .setHeight(height)

                            .setFrameRect(new Rectangle2D.Double(
                                    .06 * width,
                                    .13 * height,
                                    .88 * width,
                                    .81 * height))
                            .setBgrColor(Color.LIGHT_GRAY)
                            .setHistFrameColor(Color.WHITE)
                            .setHistFrameBorderWidth(10)
                            .setHistFrameBorderColor(Color.GRAY)
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

    public static class Histogram {

        private final HistParams histParams;
        private final Point2D.Double factors;

        public Histogram(HistParams histParams) {
            this.histParams = histParams;
            factors = new Point2D.Double(1 / histParams.getWidth(), 1 / histParams.getHeight());
            StdDraw.setCanvasSize((int) histParams.getWidth(), (int) histParams.getHeight());
            repaint();
        }

        public final void repaint() {
            drawBackgroundInit();
            drawHistWindow();
        }

        private void drawBackgroundInit() {
            StdDraw.setPenColor(histParams.getBgrColor());
            StdDraw.filledRectangle(.5, .5, .5, .5);
        }

        private void drawHistWindow() {
            StdRectParams params = calcStdRectParam(histParams.getFrameRect(), histParams.getHistFrameBorderWidth(),
                                                    factors.x, factors.y);
            drawHistWindowBgr(params);
            drawHistWindowBorder(params);
        }

        private void drawHistWindowBgr(StdRectParams params) {
            StdDraw.setPenColor(histParams.getHistFrameColor());
            StdDraw.filledRectangle(params.cX, params.cY, params.hW, params.hH);
            StdDraw.setPenColor(StdDraw.BLACK);
        }

        private void drawHistWindowBorder(StdRectParams params) {
            StdDraw.setPenColor(histParams.getHistFrameBorderColor());
            double radius = toStdPen(histParams.getHistFrameBorderWidth());
            StdDraw.setPenRadius(radius);
            StdDraw.rectangle(params.cX, params.cY, params.hW, params.hH);
        }

        private double toStd(double realSize, double max) {
            return realSize / max;
        }

    }

    @Data
    @Accessors(chain = true)
    public static class HistParams {
        private double width;
        private double height;
        private Rectangle2D.Double frameRect;

        private Color bgrColor;
        private Color histFrameColor;
        private double histFrameBorderWidth;
        private Color histFrameBorderColor;
    }

    /**
     * Parameters for {@link StdDraw#rectangle} method
     */
    @Data
    @AllArgsConstructor
    public static class StdRectParams {
        /** the x-coordinate of the center of the rectangle */
        private final double cX;
        /** the y-coordinate of the center of the rectangle */
        private final double cY;
        /** one half the width of the rectangle */
        private final double hW;
        /** one half the height of the rectangle */
        private final double hH;
    }


    public static abstract class HistArea {

        private final Rectangle2D.Double rect;

        protected HistArea(Rectangle2D.Double rect) {
            this.rect = rect;
        }

        public void drawDebugRect() {
            StdDraw.setPenRadius(.002);
//            StdDraw.rectangle();
        }
    }
    // TODO: 6/27/20 Create 4 classes-descendants of HistArea:
    //  CaptionArea
    //  YAxisArea
    //  XAxisArea
    //  MainArea
    // TODO: 6/27/20 Draw debug rects bounding them and fix them to fit their proper space





}
