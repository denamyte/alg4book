package org.denamyte.algs4.code.common;

public class ScaledPoint extends Point {
    public ScaledPoint(double x, double y, Point factors) {
        super(factors.x * x, factors.y * y);
    }
}
