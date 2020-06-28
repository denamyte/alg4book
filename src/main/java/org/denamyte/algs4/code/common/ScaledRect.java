package org.denamyte.algs4.code.common;

public class ScaledRect extends Rect {
    public ScaledRect(double x, double y, double w, double h, Point factors) {
        super(factors.x * x, factors.y * y, factors.x * w, factors.y * h);
    }
}
