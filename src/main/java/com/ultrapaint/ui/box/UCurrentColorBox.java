package com.ultrapaint.ui.box;

import com.ultrapaint.App;
import com.ultrapaint.ui.button.UButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class UCurrentColorBox extends BorderPane {
    public Circle circle;
    public UCurrentColorBox(App app) {
        super();

        circle = new Circle(15);
        circle.setStrokeWidth(3);
        circle.setStroke(Color.DARKGRAY);
        circle.setFill(Color.BLACK);

        Label label = new Label("Current color");

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        setCenter(circle);
        setBottom(label);
    }
}
