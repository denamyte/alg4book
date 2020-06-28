package org.denamyte.algs4.code.histogram;

import edu.princeton.cs.algs4.StdDraw;
import org.denamyte.algs4.code.common.Point;
import org.denamyte.algs4.code.common.Rect;
import org.denamyte.algs4.code.histogram.area.CaptionArea;
import org.denamyte.algs4.code.histogram.area.XAxisArea;
import org.denamyte.algs4.code.histogram.area.YAxisArea;

import java.awt.*;

public class Histogram {

    private final HistParams histParams;
    private final Point factors;
    private final XAxisArea xAxis;
    private final CaptionArea captionArea;
    private final YAxisArea yAxis;

    public Histogram(HistParams histParams) {
        this.histParams = histParams;
        factors = new Point(1 / histParams.getScrWidth(), 1 / histParams.getScrHeight());
        StdDraw.setCanvasSize((int) histParams.getScrWidth(), (int) histParams.getScrHeight());

        Rect fRect = histParams.getFrameRect();
        double bWidth = histParams.getHistFrameBorderWidth();
        xAxis = new XAxisArea(new Rect(fRect.x + bWidth, 0, fRect.width - bWidth * 2, fRect.y),
                              factors);
        captionArea = new CaptionArea(new Rect(fRect.x + bWidth, fRect.y + fRect.height, fRect.width - bWidth * 2, histParams.getScrHeight() - (fRect.y + fRect.height)),
                                      factors, histParams.getCaptionColor(), histParams.getCaptionText());
        yAxis = new YAxisArea(new Rect(0, fRect.y + bWidth, fRect.x, fRect.height - bWidth * 2),
                              factors);
        repaint();
    }

    public final void repaint() {
        drawBackgroundInit();
        drawHistWindow();
        xAxis.draw();
        yAxis.draw();
        captionArea.draw();
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
