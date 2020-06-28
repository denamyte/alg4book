package org.denamyte.algs4.code.histogram;

import org.denamyte.algs4.code.common.Point;
import org.denamyte.algs4.code.common.Rect;

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
}
