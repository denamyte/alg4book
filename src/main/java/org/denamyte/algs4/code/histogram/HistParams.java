package org.denamyte.algs4.code.histogram;

import lombok.Data;
import lombok.experimental.Accessors;
import org.denamyte.algs4.code.common.Rect;

import java.awt.*;

@Data
@Accessors(chain = true)
public class HistParams {
    private double scrWidth;
    private double scrHeight;
    private Rect frameRect;

    private Color bgrColor;
    private Color histFrameColor;
    private double histFrameBorderWidth;
    private Color histFrameBorderColor;

    private Color captionColor;
    private String captionText;
}
