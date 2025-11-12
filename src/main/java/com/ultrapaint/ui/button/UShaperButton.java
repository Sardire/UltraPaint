package com.ultrapaint.ui.button;

import com.ultrapaint.App;
import com.ultrapaint.constants.ShapeID;
import com.ultrapaint.constants.ToolID;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;


public class UShaperButton extends UButton{
    double startX, startY;
    public UShaperButton(App app, ShapeID s){
        super();
        switch (s){
            case ShapeID.RECTANGLE:
                setRectangle(app);
                break;
            case ShapeID.LINE:
                setLine(app);
                break;
            case ShapeID.ELLIPSE:
                setEllipse(app);
                break;
            default:
                break;
        }
    }

    private void setRectangle(App app){
        Rectangle rectangle = new Rectangle(0, 0, 14, 14);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(1);
        this.setGraphic(rectangle);
        this.setOnMouseClicked(e -> {
            app.shaperTool.setShape(app, ShapeID.RECTANGLE);
            app.shaperTool.setBehavior(app);
        });
    }

    private void setLine(App app){
        Line line = new Line(0, 0, 14, 14);
        line.setFill(Color.BLACK);
        this.setGraphic(line);
        this.setOnMouseClicked(e -> {
            app.shaperTool.setShape(app, ShapeID.LINE);
            app.shaperTool.setBehavior(app);
        });
    }

    private void setEllipse(App app){
        Circle circle = new Circle(7);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(1);
        this.setGraphic(circle);
        this.setOnMouseClicked(e -> {
            app.shaperTool.setShape(app, ShapeID.ELLIPSE);
            app.shaperTool.setBehavior(app);
        });
    }
}
