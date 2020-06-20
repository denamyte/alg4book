package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.denamyte.algs4.code.utils.Utils;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.31.png" alt="Task screenshot"><br>
 * Please provide 2 command-line arguments (int and double) as stated in the image above.
 */
public class Task_1_1_31 {

    private static final int MAX_DOTS_COUNT = 30;
    private static final double CENTER_CRD = .5;
    private static final Point CENTER = new Point(CENTER_CRD, CENTER_CRD);
    private static final double CIRCLE_RADIUS = .4;
    private static final double DOT_SIZE = .05;
    private static final double LINE_SIZE = .015;
    private static final double CIRCLE_DEGREES = 360.0;
    private static final int CANVAS_SIZE = 1024;

    public static void main(String[] args) {
        StdRandom.setSeed(System.currentTimeMillis());
        Utils.checkArgsLength(args.length, 2);
        int n = Utils.checkInt(Integer.parseInt(args[0]), 0, MAX_DOTS_COUNT);
        double p = Utils.checkDouble(Double.parseDouble(args[1]), 0.0, 1.0);

        StdDraw.setCanvasSize(CANVAS_SIZE, CANVAS_SIZE);
        StdDraw.setPenRadius(DOT_SIZE);

        StdDraw.textLeft(.02, .98, String.format("Point count: %d", n));
        StdDraw.textLeft(.02, .96, String.format("Probability: %f", p));
        Point[] points = calcPointCoordinates(n);
        drawSegments(points, p);
        drawPoints(points);
    }

    public static void drawSegments(Point[] points, double probability) {
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.setPenRadius(LINE_SIZE);
        int size = points.length;
        for (int firstIndex = 0; firstIndex < size; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < size; secondIndex++) {
                if (tossACoin(probability)) {
                    Point p1 = points[firstIndex];
                    Point p2 = points[secondIndex];
                    StdDraw.line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
                }
            }
        }
    }

    public static boolean tossACoin(double probability) {
        double side = StdRandom.uniform(0.0, 1.0);
        return side <= probability;
    }

    public static Point[] calcPointCoordinates(int pointCount) {
        Point[] points = new Point[pointCount];
        for (int i = 0; i < pointCount; i++) {
            points[i] = calcPointOnCircumference(CENTER, CIRCLE_RADIUS, calcDotAngle(i, pointCount));
        }
        return points;
    }

    public static Point calcPointOnCircumference(Point center, double radius, double degrees) {
        double radians = toRadians(degrees);
        return new Point(center.getX() + radius * Math.cos(radians),
                         center.getY() + radius * Math.sin(radians));
    }

    public static double toRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    public static double calcDotAngle(int dotIndex, int dotCount) {
        Utils.checkInt(dotIndex, 0, dotCount);
        return CIRCLE_DEGREES / dotCount * dotIndex;
    }

    public static void drawPoints(Point[] points) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(DOT_SIZE);
        for (Point point : points)
            StdDraw.point(point.getX(), point.getY());
    }

    @Data
    @AllArgsConstructor
    public static class Point {
        double x, y;
    }

}
