package com.ultrapaint.core;

import com.ultrapaint.App;
import com.ultrapaint.constants.ShapeID;
import com.ultrapaint.constants.ToolID;
import com.ultrapaint.core.toolpreview.EllipsePreview;
import com.ultrapaint.core.toolpreview.LinePreview;
import com.ultrapaint.core.toolpreview.Preview;
import com.ultrapaint.core.toolpreview.RectanglePreview;
import javafx.scene.shape.Shape;

public class ShaperTool extends Tool{
    Preview shapePreview;
    RectanglePreview rectanglePreview;
    LinePreview linePreview;
    EllipsePreview ellipsePreview;
    double startX, startY, lineWidth;
    public ShaperTool(App app){
        super();
        lineWidth = 1;
        rectanglePreview = new RectanglePreview(app);
        linePreview = new LinePreview(app);
        ellipsePreview = new EllipsePreview(app);
    }

    @Override
    public void setBehavior(App app){
        app.currentTool = ToolID.SHAPER;

        app.canvasPane.setOnMousePressed(e -> {
            app.canvas.requestFocus();
            app.gc.setLineWidth(app.currentEdgeSize);
            startX = e.getX();
            startY = e.getY();
            shapePreview.setOnPressed(app, startX, startY);
        });

        app.canvasPane.setOnMouseMoved(e -> {
            shapePreview.setOnMoved(app, e.getX(), e.getY());
        });

        app.canvasPane.setOnMouseDragged(e -> {
            shapePreview.setOnDragged(app, e.getX(), e.getY());
        });

        app.canvasPane.setOnMouseReleased(e -> {
            shapePreview.setOnReleased(app, e.getX(), e.getY());
        });
    }

    public void setShape(App app, ShapeID s){
        switch (s){
            case ShapeID.RECTANGLE:
                shapePreview = rectanglePreview;
                break;
            case ShapeID.LINE:
                shapePreview = linePreview;
                break;
            case ShapeID.ELLIPSE:
                shapePreview = ellipsePreview;
                break;
            default:
                break;
        }
    }
}
