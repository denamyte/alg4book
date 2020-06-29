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
    private Color bgrColor;

    private Rect mainAreaRect;
    private Color mainAreaBgrColor;
    private double mainAreaBorderWidth;
    private Color mainAreaBorderColor;

    private Color captionColor;
    private String captionText;
}
