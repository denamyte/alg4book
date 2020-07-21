package org.denamyte.algs4.code.histogram.area;

import org.denamyte.algs4.code.common.Point;
import org.denamyte.algs4.code.common.Rect;
import org.denamyte.algs4.code.histogram.HistUtils;

import java.awt.*;

public class MainArea extends HistArea {
    private final double borderWidth;
    private final Color borderColor;
    private final Color bgrColor;
    private final boolean drawHorzLines;

    public MainArea(Rect rect, Point factors, double borderWidth, Color borderColor, Color bgrColor, boolean drawHorzLines) {
        super(rect, factors);
        this.borderWidth = borderWidth;
        this.borderColor = borderColor;
        this.bgrColor = bgrColor;
        this.drawHorzLines = drawHorzLines;
    }

    @Override
    void drawContent() {
        HistUtils.calcAndPaintRect(bgrColor, rect, borderWidth, factors, true);
        HistUtils.calcAndPaintRect(borderColor, rect, borderWidth, factors, false);
    }

    @Override
    public Color getDebugColor() {
        return Color.WHITE;
//        return new Color(0, 255, 200, 150).brighter();
    }
}
