package com.ultrapaint.core;



import com.ultrapaint.App;
import com.ultrapaint.constants.ToolID;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EraserTool extends Tool {
    private double prevX = 0, prevY = 0, x, y;
    private final double ERASER_PACE = 0.5;
    public Rectangle eraserPreview = new Rectangle(0, 0, 0, 0);

    public EraserTool(App app) {
        super();

        eraserPreview.setStrokeWidth(1);
        eraserPreview.setWidth(app.currentEraserSize);
        eraserPreview.setHeight(app.currentEraserSize);
        eraserPreview.setFill(Color.WHITE);
        eraserPreview.setStroke(Color.BLACK);
        eraserPreview.setVisible(false);
        app.canvasPane.getChildren().add(eraserPreview);
    }
    
    @Override
    public void setBehavior(App app) {
        app.currentTool = ToolID.ERASER;

        app.canvasPane.setOnMousePressed(e -> {
            app.canvas.requestFocus();
            prevX = e.getX();
            prevY = e.getY();
            app.gc.fillRect(e.getX() - app.currentEraserSize/2, e.getY() - app.currentEraserSize/2, app.currentEraserSize, app.currentEraserSize);
        });

        app.canvasPane.setOnMouseMoved(e -> {
            app.canvas.requestFocus();
            x = e.getX();
            y = e.getY();
            if (y < 0) eraserPreview.setVisible(false);
            else{
                eraserPreview.setVisible(true);
                eraserPreview.setWidth(app.currentEraserSize);
                eraserPreview.setHeight(app.currentEraserSize);
                eraserPreview.setX(x - app.currentEraserSize / 2);
                eraserPreview.setY(y - app.currentEraserSize / 2);
            }
        });

        app.canvasPane.setOnMouseDragged(e -> {
            app.canvas.requestFocus();
            x = e.getX();
            y = e.getY();
            eraserPreview.setWidth(app.currentEraserSize);
            eraserPreview.setHeight(app.currentEraserSize);
            eraserPreview.setX(x - app.currentEraserSize / 2);
            eraserPreview.setY(y - app.currentEraserSize / 2);
            app.gc.fillRect(e.getX() - app.currentEraserSize/2, e.getY() - app.currentEraserSize/2, app.currentEraserSize, app.currentEraserSize);

            // Sử dụng nội suy tuyến tính để xóa các điểm giữa hai vị trí chuột
            double dist = Math.hypot(x - prevX, y - prevY);
            int steps = (int)(dist / ERASER_PACE) + 1;
            for (int i = 0; i <= steps; i++) {
                double t = (double)i / steps;
                double ix = prevX + t * (x - prevX);
                double iy = prevY + t * (y - prevY);
                app.gc.fillRect(ix - app.currentEraserSize/2, iy - app.currentEraserSize/2, app.currentEraserSize, app.currentEraserSize);
            }

            prevX = x;
            prevY = y;
        });
    }
}