package com.ultrapaint.core.toolpreview;

import com.ultrapaint.App;
import javafx.scene.shape.Line;

public class LinePreview extends Preview{
    double prevX, prevY;
    private final Line linePreview = new Line(0,0,1, 1);
    public LinePreview(App app){
        linePreview.setVisible(false);
        app.canvasPane.getChildren().add(linePreview);
    }
    @Override
    public void setOnPressed(App app, double x, double y) {
        prevX = x;
        prevY = y;
        linePreview.setStrokeWidth(app.currentEdgeSize);
        linePreview.setStroke(app.currentColor);
        linePreview.setVisible(true);
        setCoordinate(linePreview, x, y, x, y);
    }

    @Override
    public void setOnMoved(App app, double x, double y) {

    }

    @Override
    public void setOnDragged(App app, double x, double y) {
        setCoordinate(linePreview, prevX, prevY, x, y);
    }

    @Override
    public void setOnReleased(App app, double x, double y) {
        linePreview.setVisible(false);
        app.gc.setStroke(app.currentColor);
        app.gc.setLineWidth(app.currentEdgeSize);
        app.gc.strokeLine(prevX, prevY, x, y);
    }

    @Override
    public void setVisible(boolean state) {
        linePreview.setVisible(state);
    }

    public void setCoordinate(Line line, double startX, double startY, double endX, double endY){
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);
    }
}
