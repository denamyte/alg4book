package org.denamyte.algs4.code.histogram.area;

import edu.princeton.cs.algs4.StdDraw;
import org.denamyte.algs4.code.common.Point;
import org.denamyte.algs4.code.common.Rect;
import org.denamyte.algs4.code.common.ScaledPoint;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

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
        StdDraw.setPenColor(captionColor);

        // TODO: 6/28/20 Extract all the functionality of working with font - into a separate aspect

        Font prevFont = StdDraw.getFont();
        @SuppressWarnings("unchecked")
        Map<TextAttribute, Object> attributes = (Map<TextAttribute, Object>) prevFont.getAttributes();
        System.out.println(attributes);
        System.out.println(prevFont);
        attributes.put(TextAttribute.SIZE, 18);
        attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
        Font font = new Font(attributes);
        StdDraw.setFont(font);

        ScaledPoint point = new ScaledPoint(rect.x + rect.width / 2, rect.y + rect.height * .4, factors);
        StdDraw.text(point.x, point.y, caption);

        StdDraw.setFont(prevFont);
    }

    @Override
    public Color getDebugColor() {
//        return new Color(0, 200, 50, 0);
        return new Color(0, 150, 0, 150);
    }
}
