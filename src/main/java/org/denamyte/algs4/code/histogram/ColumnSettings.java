package org.denamyte.algs4.code.histogram;

import lombok.Builder;
import lombok.Data;

import java.awt.*;

/**
 * Contains settings of histogram columns and rows (horizontal lines on specific numbers of Y-axis)
 */
@Data
@Builder
public class ColumnSettings {
    private final double paddingSide;     // The padding on the left and right sides of the histogram columns
    private final double paddingBetween;  // The padding between the histogram columns

    private final Color barColor;
    private final boolean borders;             // Whether to draw column borders
    private final boolean borderSizeRelative;  // Whether the size of the columns border depends on the width of the columns
    private final double borderSize;           // The width of the borders: in case borderSizeRelative is false, it is absolute (pixels); otherwise, it is a coefficient of the column width
}
