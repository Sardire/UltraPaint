package com.ultrapaint.core.toolpreview;

import com.ultrapaint.App;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EraserPreview extends Preview {
    private final Rectangle eraserPreview = new Rectangle(0, 0, 1, 1);
    public EraserPreview(App app){
        eraserPreview.setStrokeWidth(1);
        eraserPreview.setWidth(app.currentEraserSize);
        eraserPreview.setHeight(app.currentEraserSize);
        eraserPreview.setFill(Color.WHITE);
        eraserPreview.setStroke(Color.BLACK);
        eraserPreview.setVisible(false);
        app.canvasPane.getChildren().add(eraserPreview);
    }

    public void setOnPressed(App app, double x, double y){}

    public void setOnMoved(App app, double x, double y){
        eraserPreview.setVisible(true);
        eraserPreview.setWidth(app.currentEraserSize);
        eraserPreview.setHeight(app.currentEraserSize);
        eraserPreview.setX(x - app.currentEraserSize / 2);
        eraserPreview.setY(y - app.currentEraserSize / 2);
    }

    public void setOnDragged(App app, double x, double y){
        eraserPreview.setWidth(app.currentEraserSize);
        eraserPreview.setHeight(app.currentEraserSize);
        eraserPreview.setX(x - app.currentEraserSize / 2);
        eraserPreview.setY(y - app.currentEraserSize / 2);
    }

    public void setOnReleased(App app, double x, double y){}

    public void setVisible(boolean state){
        eraserPreview.setVisible(state);
    }

    public void resize(double size){
        eraserPreview.setWidth(size);
        eraserPreview.setHeight(size);
    }
}
