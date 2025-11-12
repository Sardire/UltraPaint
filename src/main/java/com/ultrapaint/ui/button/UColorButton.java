package com.ultrapaint.ui.button;

import com.ultrapaint.App;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class UColorButton extends UButton{
    public UColorButton(App app, Color color){
        super();
        Circle circle = new Circle(7);
        circle.setFill(color);
        circle.setStroke(Color.DARKGRAY);
        circle.setStrokeWidth(1);
        this.setGraphic(circle);
        this.setOnMouseClicked(e -> app.currentColor = color);
    }
}
