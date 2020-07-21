package org.denamyte.algs4.code.histogram;

import edu.princeton.cs.algs4.StdDraw;
import org.denamyte.algs4.code.common.Point;
import org.denamyte.algs4.code.common.Rect;
import org.denamyte.algs4.code.histogram.area.*;

//@Data
public class Histogram {

    private final BackgroundArea backgroundArea;
    private final MainArea mainArea;
    private final XAxisArea xAxis;
    private final CaptionArea captionArea;
    private final YAxisArea yAxis;
    private final HistParams histParams;
    private HistData histData;

    public Histogram(HistParams histParams, HistData histData) {
        this.histParams = histParams;
        Point factors = new Point(1 / histParams.getScrWidth(), 1 / histParams.getScrHeight());
        StdDraw.setCanvasSize((int) histParams.getScrWidth(), (int) histParams.getScrHeight());

        Rect fRect = histParams.getMainAreaRect();
        double bWidth = histParams.getMainAreaBorderWidth();
        backgroundArea = new BackgroundArea(new Rect(0, 0, histParams.getScrWidth(), histParams.getScrHeight()),
                                            factors, histParams.getBgrColor());
        mainArea = new MainArea(histParams.getMainAreaRect(), factors, histParams.getMainAreaBorderWidth(),
                                histParams.getMainAreaBorderColor(), histParams.getMainAreaBgrColor(),
                                histParams.isDrawHorzLinesInMainArea());
        xAxis = new XAxisArea(new Rect(fRect.x + bWidth, 0, fRect.width - bWidth * 2, fRect.y), factors);
        captionArea = new CaptionArea(new Rect(fRect.x + bWidth, fRect.y + fRect.height
                , fRect.width - bWidth * 2, histParams.getScrHeight() - (fRect.y + fRect.height))
                , factors, histParams.getCaptionColor(), histParams.getCaptionText());
        yAxis = new YAxisArea(new Rect(0, fRect.y + bWidth, fRect.x, fRect.height - bWidth * 2), factors);
        setHistData(histData);
    }

    public void setHistData(HistData histData) {
        if (histData == null || histData.getData() == null)
            throw new IllegalArgumentException("histData must not be null; histData.data must not be null either.");
        this.histData = histData;
        invalidateData();
    }

    private void invalidateData() {
        calculateAndPassData();
        repaint();
    }

    private void calculateAndPassData() {
        // TODO: 7/21/20
        //  - Take ColumnSettings, take histogram data, calculate the actual bar sizes from them
        //  - every time the histogram data changes, the actual sizes should be recalculated, and the histogram should be redrawn
        ColumnSettings cSet = histParams.getColumnSettings();
        int maxValue = getMaxValue();
    }

    private int getMaxValue() {
        return histData.getData()
                .stream()
                .map(HistData.HistUnit::getValue)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public final void repaint() {
        backgroundArea.draw();
        xAxis.draw();
        yAxis.draw();
        captionArea.draw();
        mainArea.draw();
    }

    private double toStd(double realSize, double max) {
        return realSize / max;
    }

}
