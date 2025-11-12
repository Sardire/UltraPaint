package com.ultrapaint.core.toolpreview;

import com.ultrapaint.App;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

public class EllipsePreview extends Preview{
    double prevX, prevY;
    private final Ellipse ellipsePreview = new Ellipse(0,0,1,1);

    public EllipsePreview(App app){
        ellipsePreview.setVisible(false);
        ellipsePreview.setFill(Color.TRANSPARENT);
        app.canvasPane.getChildren().add(ellipsePreview);
    }
    @Override
    public void setOnPressed(App app, double x, double y) {
        prevX = x;
        prevY = y;
        ellipsePreview.setVisible(true);
        ellipsePreview.setStroke(app.currentColor);
        ellipsePreview.setStrokeWidth(app.currentEdgeSize);
        setCoordinate(ellipsePreview, x, y, x, y);
    }

    @Override
    public void setOnMoved(App app, double x, double y) {

    }

    @Override
    public void setOnDragged(App app, double x, double y) {
        setCoordinate(ellipsePreview, prevX, prevY, x, y);
    }

    @Override
    public void setOnReleased(App app, double x, double y) {
        ellipsePreview.setVisible(false);
        app.gc.setLineWidth(app.currentEdgeSize);
        app.gc.setStroke(app.currentColor);
        app.gc.strokeOval(Math.min(prevX, x), Math.min(prevY, y), Math.abs(prevX - x), Math.abs(prevY - y));
    }

    @Override
    public void setVisible(boolean state) {
        ellipsePreview.setVisible(state);
    }

    public void setCoordinate(Ellipse ellipse, double startX, double startY, double endX, double endY){
        ellipsePreview.setCenterX((startX + endX)/2);
        ellipsePreview.setCenterY((startY + endY)/2);
        ellipsePreview.setRadiusX(Math.abs(startX - endX)/2);
        ellipsePreview.setRadiusY(Math.abs(startY - endY)/2);
    }
}
