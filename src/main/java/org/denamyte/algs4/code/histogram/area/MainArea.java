package org.denamyte.algs4.code.histogram.area;

import org.denamyte.algs4.code.common.Point;
import org.denamyte.algs4.code.common.Rect;
import org.denamyte.algs4.code.histogram.HistUtils;

import java.awt.*;

public class MainArea extends HistArea {
    private final double borderWidth;
    private final Color borderColor;
    private final Color bgrColor;

    public MainArea(Rect rect, Point factors, double borderWidth, Color borderColor, Color bgrColor) {
        super(rect, factors);
        this.borderWidth = borderWidth;
        this.borderColor = borderColor;
        this.bgrColor = bgrColor;
    }

    @Override
    void drawContent() {
        HistUtils.calcAndPaintRect(bgrColor, rect, borderWidth, factors, true);
        HistUtils.calcAndPaintRect(borderColor, rect, borderWidth, factors, false);

        // TODO: 6/29/20 remove this debug rect later
        double diff = borderWidth + 2;
        Rect contentRect = new Rect(rect.x + diff,
                                    rect.y + diff,
                                    rect.width - (diff) * 2,
                                    rect.height - (diff) * 2);
        HistUtils.calcAndPaintRect(Color.BLUE, contentRect, 2, factors, false);
    }

    @Override
    public Color getDebugColor() {
        return new Color(0, 255, 200, 150).brighter();
    }
}
