package org.denamyte.algs4.code.histogram;

import edu.princeton.cs.algs4.StdDraw;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.denamyte.algs4.code.common.Point;

/**
 * Parameters for {@link StdDraw#rectangle} method
 */
@Data
@AllArgsConstructor
public class StdRectParams {
    /**
     * The coordinates of the center of this rectangle
     */
    public final Point c;
    /**
     * one half the width of this rectangle
     */
    public final double hW;
    /**
     * one half the height of this rectangle
     */
    public final double hH;
}
