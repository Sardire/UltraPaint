package com.ultrapaint.ui;

import com.ultrapaint.App;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class UColorBar extends HBox {
    Color[] colors = {
        Color.BLACK, Color.DARKGRAY, Color.GRAY,
        Color.LIGHTGRAY, Color.WHITE, Color.RED,
        Color.ORANGE, Color.YELLOW, Color.GREEN,
        Color.BLUE, Color.INDIGO, Color.VIOLET
    };
    public UColorBar(App app){
        super();
        GraphicsContext gc = app.canvas.getGraphicsContext2D();

        for (int i = 0;i < (colors.length + 2) / 3;i++) {
            VBox vbox = new VBox();
            this.getChildren().add(vbox);
        }
        
        for (int i = 0;i < colors.length;i++) {
            VBox vbox = (VBox)this.getChildren().get(i / 3);
            Color color = colors[i];
            UButton colorButton = new UButton();
            colorButton.setOnMouseClicked(e -> {
                gc.setStroke(color);
            });
            Circle circle = new Circle(7);
            circle.setFill(color);
            colorButton.setGraphic(circle);
            vbox.getChildren().add(colorButton);
        }
    }
}