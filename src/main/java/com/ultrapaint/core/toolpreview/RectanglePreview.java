package com.ultrapaint.core.toolpreview;

import com.ultrapaint.App;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class RectanglePreview extends Preview {
    double prevX, prevY;
    private final Rectangle rectanglePreview = new Rectangle(0,0,1,1);
    public RectanglePreview(App app){
        rectanglePreview.setVisible(false);
        app.canvasPane.getChildren().add(rectanglePreview);
    }

    @Override
    public void setOnPressed(App app, double x, double y){
        prevX = x;
        prevY = y;
        rectanglePreview.setStroke(app.currentColor);
        rectanglePreview.setFill(Color.TRANSPARENT);
        rectanglePreview.setVisible(true);
    }

    @Override
    public void setOnMoved(App app, double x, double y){}

    @Override
    public void setOnDragged(App app, double x, double y){
        setCoordinate(x, y);
    }

    @Override
    public void setOnReleased(App app, double x, double y){
        rectanglePreview.setVisible(false);
        app.gc.setStroke(app.currentColor);
        app.gc.setLineWidth(app.currentEdgeSize);
        app.gc.strokeRect(Math.min(prevX, x), Math.min(prevY, y), Math.abs(x - prevX), Math.abs(y - prevY));
    }

    @Override
    public void setVisible(boolean state){
        rectanglePreview.setVisible(state);
    }

    public void setCoordinate(double endX, double endY){
        rectanglePreview.setX(prevX);
        rectanglePreview.setY(prevY);
        rectanglePreview.setWidth(Math.abs(prevX - endX));
        rectanglePreview.setHeight(Math.abs(prevY - endY));
    }
}
