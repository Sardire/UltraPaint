package com.ultrapaint.core;

import com.ultrapaint.App;
import com.ultrapaint.constants.ToolID;

import javafx.scene.canvas.GraphicsContext;

public class BrushTool extends Tool {
    double prevX = 0, prevY = 0;

    public BrushTool(App app) {
        super();
    }

    @Override
    public void setBehavior(App app) {
        GraphicsContext gc = app.canvas.getGraphicsContext2D();
        app.currentTool = ToolID.BRUSH;

        app.canvasPane.setOnMousePressed(e -> {
            prevX = e.getX();
            prevY = e.getY();

            gc.setStroke(app.currentColor);
            gc.setLineWidth(app.currentBrushSize);
            gc.strokeLine(prevX, prevY, prevX, prevY);
        });

        app.canvasPane.setOnMouseMoved(e -> {
            app.canvas.requestFocus();
        });

        app.canvasPane.setOnMouseDragged(e -> {
            double x = e.getX();
            double y = e.getY();

            gc.strokeLine(prevX, prevY, x, y);

            prevX = x;
            prevY = y;
        });
    }
}