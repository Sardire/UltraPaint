package com.ultrapaint.core.tool;

import com.ultrapaint.App;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ColorPickerTool extends Tool{
    Color color;
    public ColorPickerTool(App app){
        super();
    }
    @Override
    public void setBehavior(App app) {
        app.canvasPane.setOnMouseReleased(e -> {
            WritableImage image = app.mainCanva.snapshot(null, null);
            color = image.getPixelReader().getColor((int)e.getX(), (int)e.getY());
            app.toolbar.setColor(color);
        });

        app.canvasPane.setOnMousePressed(e -> {});

        app.canvasPane.setOnMouseMoved(e -> {});

        app.canvasPane.setOnMouseDragged(e -> {});

        app.canvasPane.setOnMouseExited(e -> {
        });

        app.canvasPane.setOnMouseEntered(e -> {
        });
    }
}
