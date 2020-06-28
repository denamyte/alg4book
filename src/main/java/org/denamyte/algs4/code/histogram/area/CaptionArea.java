package org.denamyte.algs4.code.histogram.area;

import org.denamyte.algs4.code.common.Point;
import org.denamyte.algs4.code.common.Rect;

import java.awt.*;

public class CaptionArea extends HistArea {

    protected CaptionArea(Rect rect, Point factors) {
        super(rect, factors);
    }

    @Override
    public void drawContent() {
//            calcStdRectParam(getRect(), .002, );
//            StdDraw.rectangle();
    }

    @Override
    public Color getDebugColor() {
        return new Color(0x0010FF00);
    }
}
