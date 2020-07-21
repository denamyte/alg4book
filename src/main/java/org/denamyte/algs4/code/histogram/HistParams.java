package org.denamyte.algs4.code.histogram;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.denamyte.algs4.code.common.Rect;

import java.awt.*;

@Data
@Accessors(chain = true)
@Builder
public class HistParams {
    private final double scrWidth;
    private final double scrHeight;
    private final Color bgrColor;

    private final Rect mainAreaRect;
    private final Color mainAreaBgrColor;
    private final double mainAreaBorderWidth;
    private final Color mainAreaBorderColor;
    private final boolean drawHorzLinesInMainArea;

    private final Color captionColor;
    private final String captionText;

    private final ColumnSettings columnSettings;
}
