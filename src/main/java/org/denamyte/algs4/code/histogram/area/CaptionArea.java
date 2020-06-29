package org.denamyte.algs4.code.histogram.area;

import edu.princeton.cs.algs4.StdDraw;
import org.denamyte.algs4.code.common.Point;
import org.denamyte.algs4.code.common.Rect;
import org.denamyte.algs4.code.common.ScaledPoint;
import org.denamyte.algs4.code.common.utils.FontAspect;

import java.awt.*;
import java.awt.font.TextAttribute;

/**
 * A rectangular area to the top of the histogram main window
 */
public class CaptionArea extends HistArea {
    private final Color captionColor;
    private final String caption;

    public CaptionArea(Rect rect, Point factors, Color captionColor, String caption) {
        super(rect, factors);
        this.captionColor = captionColor;
        this.caption = caption;
    }

    @Override
    public void drawContent() {

        new FontAspect()
                .setSize(18f)
                .setWeight(TextAttribute.WEIGHT_BOLD)
                .withFont(() -> {
                    StdDraw.setPenColor(captionColor);
                    ScaledPoint point = new ScaledPoint(rect.x + rect.width / 2, rect.y + rect.height * .4, factors);
                    StdDraw.text(point.x, point.y, caption);
                });
    }

    @Override
    public Color getDebugColor() {
        return new Color(0, 150, 0, 150);
    }
}
