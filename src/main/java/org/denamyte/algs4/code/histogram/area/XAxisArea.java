package org.denamyte.algs4.code.histogram.area;

import org.denamyte.algs4.code.common.Point;
import org.denamyte.algs4.code.common.Rect;

import java.awt.*;

public class XAxisArea extends HistArea {

    public XAxisArea(Rect rect, Point factors) {
        super(rect, factors);
    }

    @Override
    public void drawContent() {
        // TODO: 6/28/20 Provide the content of this method
    }

    @Override
    public Color getDebugColor() {
        return new Color(0x500010FF);
    }
}
