package org.denamyte.algs4.code.histogram;

import edu.princeton.cs.algs4.StdDraw;
import org.denamyte.algs4.code.common.Point;
import org.denamyte.algs4.code.common.Rect;
import org.denamyte.algs4.code.histogram.area.*;

public class Histogram {

    private final BackgroundArea backgroundArea;
    private final MainArea mainArea;
    private final XAxisArea xAxis;
    private final CaptionArea captionArea;
    private final YAxisArea yAxis;

    public Histogram(HistParams histParams) {
        Point factors = new Point(1 / histParams.getScrWidth(), 1 / histParams.getScrHeight());
        StdDraw.setCanvasSize((int) histParams.getScrWidth(), (int) histParams.getScrHeight());

        Rect fRect = histParams.getMainAreaRect();
        double bWidth = histParams.getMainAreaBorderWidth();
        backgroundArea = new BackgroundArea(new Rect(0, 0, histParams.getScrWidth(), histParams.getScrHeight()),
                                            factors, histParams.getBgrColor());
        mainArea = new MainArea(histParams.getMainAreaRect(), factors, histParams.getMainAreaBorderWidth(),
                                histParams.getMainAreaBorderColor(), histParams.getMainAreaBgrColor());
        xAxis = new XAxisArea(new Rect(fRect.x + bWidth, 0, fRect.width - bWidth * 2, fRect.y),
                              factors);
        captionArea = new CaptionArea(new Rect(fRect.x + bWidth, fRect.y + fRect.height, fRect.width - bWidth * 2, histParams.getScrHeight() - (fRect.y + fRect.height)),
                                      factors, histParams.getCaptionColor(), histParams.getCaptionText());
        yAxis = new YAxisArea(new Rect(0, fRect.y + bWidth, fRect.x, fRect.height - bWidth * 2),
                              factors);
        repaint();
    }

    public final void repaint() {
        backgroundArea.draw();
        mainArea.draw();
        xAxis.draw();
        yAxis.draw();
        captionArea.draw();
    }

    private double toStd(double realSize, double max) {
        return realSize / max;
    }

}
