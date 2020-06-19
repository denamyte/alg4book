package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import org.denamyte.algs4.code.utils.Utils;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.31.png" alt="Task screenshot"><br>
 * Please provide 2 command-line arguments (int and double) as stated in the image above.
 */
public class Task_1_1_31 {

    private static final int MAX_DOTS_COUNT = 30;
    private static final double CENTER_CRD = .5;
    private static final double CIRCLE_RADIUS = .4;
    private static final double DOT_SIZE = .05;
    private static final double ANGLE_DIFF = 1e-3;
    private static final double CIRCLE_DEGREES = 360.0;
    private static final int CANVAS_SIZE = 512;

    public static void main(String[] args) {
        StdRandom.setSeed(System.currentTimeMillis());
        Utils.checkArgsLength(args.length, 2);
        int n = Utils.checkInt(Integer.parseInt(args[0]), 0, MAX_DOTS_COUNT);
        double p = Utils.checkDouble(Double.parseDouble(args[1]), 0.0, 1.0);
        StdDraw.setCanvasSize(CANVAS_SIZE, CANVAS_SIZE);
        StdDraw.setPenRadius(DOT_SIZE);
        drawDots(n);
    }

    public static void drawSegments(int dotsCount, double probability) {
        StdDraw.setPenColor(StdDraw.GRAY);
        for (int firstIndex = 0; firstIndex < dotsCount; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < dotsCount; secondIndex++) {
                if (tossACoin(probability)) {
                    // TODO: 6/20/20 calculate the actual coordinates of the dots
                    //
                }
            }
        }
    }

    public static boolean tossACoin(double probability) {
        double coin = StdRandom.uniform(0.0, 1.0);
        return coin <= probability;
    }

    public static void drawDots(int dotNumber) {
        StdDraw.setPenColor(StdDraw.BLACK);
        Utils.checkInt(dotNumber, 0, null);
        for (int i = 0; i < dotNumber; i++) {
            drawDot(calcDotAngle(i, dotNumber));
        }
    }

    public static void drawDot(double angle) {
        StdDraw.arc(CENTER_CRD,  CENTER_CRD, CIRCLE_RADIUS, angle, angle + ANGLE_DIFF);
    }

    public static double calcDotAngle(int dotIndex, int dotCount) {
        Utils.checkInt(dotIndex, 0, dotCount);
        return CIRCLE_DEGREES / dotCount * dotIndex;
    }
}
