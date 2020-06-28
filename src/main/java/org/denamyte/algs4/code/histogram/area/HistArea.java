package org.denamyte.algs4.code.histogram.area;

import edu.princeton.cs.algs4.StdDraw;
import lombok.Data;
import org.denamyte.algs4.code.histogram.HistUtils;
import org.denamyte.algs4.code.common.Point;
import org.denamyte.algs4.code.common.Rect;
import org.denamyte.algs4.code.histogram.StdRectParams;

import java.awt.*;

@Data
public abstract class HistArea {

    private static final boolean debug = true;
    private static final boolean content = true;
    final Rect rect;
    final Point factors;

    protected HistArea(Rect rect, Point factors) {
        this.rect = rect;
        this.factors = factors;
    }

    public void draw() {
        if (debug) drawDebugRect();
        if (content) drawContent();
    }

    public void drawDebugRect() {
        StdDraw.setPenRadius(.002);
        StdDraw.setPenColor(getDebugColor());
        StdRectParams rectParams = HistUtils.calcStdRectParam(rect, .002, factors);
        StdDraw.rectangle(rectParams.c.x, rectParams.c.y, rectParams.hW, rectParams.hH);
    }

    abstract void drawContent();

    public abstract Color getDebugColor();
}
