package org.denamyte.algs4.code.histogram;

import edu.princeton.cs.algs4.StdDraw;
import org.denamyte.algs4.code.common.Point;

import java.awt.*;

public class Histogram {

    private final HistParams histParams;
    private final org.denamyte.algs4.code.common.Point factors;

    public Histogram(HistParams histParams) {
        this.histParams = histParams;
        factors = new Point(1 / histParams.getWidth(), 1 / histParams.getHeight());
        StdDraw.setCanvasSize((int) histParams.getWidth(), (int) histParams.getHeight());
        repaint();
    }

    public final void repaint() {
        drawBackgroundInit();
        drawHistWindow();
    }

    private void drawBackgroundInit() {
        StdDraw.setPenColor(histParams.getBgrColor());
        StdDraw.filledRectangle(.5, .5, .5, .5);
    }

    private void drawHistWindow() {
        StdRectParams params = HistUtils.calcStdRectParam(
                histParams.getFrameRect(), histParams.getHistFrameBorderWidth(), factors);
        drawHistWindowBgr(params);
        drawHistWindowBorder(params);
    }

    private void drawHistWindowBgr(StdRectParams params) {
        StdDraw.setPenColor(histParams.getHistFrameColor());
        StdDraw.filledRectangle(params.c.x, params.c.y, params.hW, params.hH);
        StdDraw.setPenColor(Color.BLACK);
    }

    private void drawHistWindowBorder(StdRectParams params) {
        StdDraw.setPenColor(histParams.getHistFrameBorderColor());
        double radius = HistUtils.toStdPen(histParams.getHistFrameBorderWidth());
        StdDraw.setPenRadius(radius);
        StdDraw.rectangle(params.c.x, params.c.y, params.hW, params.hH);
    }

    private double toStd(double realSize, double max) {
        return realSize / max;
    }

}
