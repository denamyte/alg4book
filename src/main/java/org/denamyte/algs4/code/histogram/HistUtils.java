package org.denamyte.algs4.code.histogram;

import edu.princeton.cs.algs4.StdDraw;
import org.denamyte.algs4.code.common.Point;
import org.denamyte.algs4.code.common.Rect;

import java.awt.*;

public class HistUtils {
    public static StdRectParams calcStdRectParam(Rect rect, double borderWidth, Point factors) {
        double stdHalfW = factors.x * ((rect.getWidth() - borderWidth) / 2);
        double stdHalfH = factors.y * ((rect.getHeight() - borderWidth) / 2);
        double stdCenterX = stdHalfW + factors.x * (rect.getX() + borderWidth / 2);
        double stdCenterY = stdHalfH + factors.y * (rect.getY() + borderWidth / 2);
        return new StdRectParams(new Point(stdCenterX, stdCenterY), stdHalfW, stdHalfH);
    }

    public static double toStdPen(double radius) {
        return radius / 512;
    }

    public static void calcAndPaintRect(Color penColor, Rect rect, double borderWidth, Point factors, boolean isFilled) {
        StdRectParams params = calcStdRectParam(rect, borderWidth, factors);
        StdDraw.setPenColor(penColor);
        if (isFilled)
            filledRect(params);
        else
            StdDraw.setPenRadius(toStdPen(borderWidth));
            outlineRect(params);
    }

    private static void filledRect(StdRectParams params) {
        StdDraw.filledRectangle(params.c.x, params.c.y, params.hW, params.hH);
    }

    private static void outlineRect(StdRectParams params) {
        StdDraw.rectangle(params.c.x, params.c.y, params.hW, params.hH);
    }

}
