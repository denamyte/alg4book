package org.denamyte.algs4.code.histogram.area;

import lombok.Data;
import org.denamyte.algs4.code.common.Point;
import org.denamyte.algs4.code.common.Rect;
import org.denamyte.algs4.code.histogram.HistUtils;

import java.awt.*;

@Data
public abstract class HistArea {

    private static final double debugRectWidth = 1;
    private static final boolean debug = true;
    private static final boolean content = true;
    final Rect rect;
    final Point factors;

    protected HistArea(Rect rect, Point factors) {
        this.rect = rect;
        this.factors = factors;
    }

    public void draw() {
        if (content) drawContent();
        if (debug) drawDebugRect();
    }

    private void drawDebugRect() {
        HistUtils.calcAndPaintRect(getDebugColor(), rect, debugRectWidth, factors, false);
    }

    abstract void drawContent();

    public abstract Color getDebugColor();
}
