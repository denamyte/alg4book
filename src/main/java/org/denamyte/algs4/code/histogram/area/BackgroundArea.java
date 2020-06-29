package org.denamyte.algs4.code.histogram.area;

import org.denamyte.algs4.code.common.Point;
import org.denamyte.algs4.code.common.Rect;
import org.denamyte.algs4.code.histogram.HistUtils;

import java.awt.*;

/**
 * The whole area of a histogram, its background.
 */
public class BackgroundArea extends HistArea {
    private final Color bgrColor;

    public BackgroundArea(Rect rect, Point factors, Color bgrColor) {
        super(rect, factors);
        this.bgrColor = bgrColor;
    }

    @Override
    void drawContent() {
        HistUtils.calcAndPaintRect(bgrColor, rect, 0, factors, true);
    }

    @Override
    public Color getDebugColor() {
        return Color.YELLOW.darker();
    }
}
