package com.ultrapaint.core.tool;

import com.ultrapaint.App;
import com.ultrapaint.constants.ToolID;

import com.ultrapaint.core.toolpreview.EraserPreview;
import javafx.scene.paint.Color;

public class EraserTool extends Tool {
    private double prevX = 0, prevY = 0, x, y;
    private final double ERASER_PACE = 0.5;
    public EraserPreview eraserPreview;

    public EraserTool(App app) {
        super();
        eraserPreview = new EraserPreview(app);
    }
    
    @Override
    public void setBehavior(App app) {
        app.currentTool = ToolID.ERASER;

        app.canvasPane.setOnMousePressed(e -> {
            app.mainCanva.requestFocus();
            app.gc.setFill(Color.WHITE);
            prevX = e.getX();
            prevY = e.getY();
            app.gc.fillRect(e.getX() - app.currentEraserSize/2, e.getY() - app.currentEraserSize/2, app.currentEraserSize, app.currentEraserSize);
        });

        app.canvasPane.setOnMouseMoved(e -> {
            app.mainCanva.requestFocus();
            eraserPreview.setOnMoved(app, e.getX(), e.getY());
        });

        app.canvasPane.setOnMouseDragged(e -> {
            app.mainCanva.requestFocus();
            x = e.getX();
            y = e.getY();

            eraserPreview.setOnDragged(app, e.getX(), e.getY());
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

        app.canvasPane.setOnMouseReleased(e -> {
            app.stateManager.takeSnapshot();
        });

        app.canvasPane.setOnMouseExited(e -> {
            eraserPreview.setVisible(false);
        });

        app.canvasPane.setOnMouseEntered(e -> {
            eraserPreview.setVisible(true);
        });
    }
}