package org.denamyte.algs4.code.common.utils;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is intended for working with font of the {@link StdDraw} class.<br/>
 * It helps to change the font ({@link StdDraw#setFont(Font)}) for the desired one, do some actions
 * with it (user defined) and then restore the previous font back
 */
public class FontAspect {
    Map<TextAttribute, Object> otherAttr = new HashMap<>(2);

    public FontAspect setSize(Float fontSize) {
        otherAttr.put(TextAttribute.SIZE, fontSize);
        return this;
    }

    /**
     * Sets the desired weight into a new font. You can use, as a parameter,
     * values {@link TextAttribute#WEIGHT_LIGHT}, {@link TextAttribute#WEIGHT_BOLD}
     * and the other predefined constants.
     * @param weight The desired weight for a new font
     * @return
     */
    public FontAspect setWeight(Float weight) {
        otherAttr.put(TextAttribute.WEIGHT, weight);
        return this;
    }

    public void withFont(FontAspectAction action) {
        Font prevFont = StdDraw.getFont();
        @SuppressWarnings("unchecked")
        Map<TextAttribute, Object> attributes = (Map<TextAttribute, Object>) prevFont.getAttributes();
        attributes.putAll(otherAttr);
        Font font = new Font(attributes);
        StdDraw.setFont(font);
        action.perform();
        StdDraw.setFont(prevFont);
    }

    public interface FontAspectAction {
        void perform();
    }
}
