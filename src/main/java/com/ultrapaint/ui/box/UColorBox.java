package com.ultrapaint.ui.box;

import com.ultrapaint.App;

import com.ultrapaint.ui.button.UColorButton;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class UColorBox extends VBox {
    Color[] colors = {
        Color.BLACK, Color.DARKGRAY, Color.GRAY,
        Color.LIGHTGRAY, Color.WHITE, Color.RED,
        Color.ORANGE, Color.YELLOW, Color.GREEN,
        Color.BLUE, Color.INDIGO, Color.VIOLET
    };
    public UColorBox(App app){
        super();

        for (int i = 0;i < (colors.length + 3) / 4;i++) {
            HBox hbox = new HBox();
            this.getChildren().add(hbox);
        }
        
        for (int i = 0;i < colors.length;i++) {
            HBox hbox = (HBox)this.getChildren().get(i / 4);
            hbox.getChildren().add(new UColorButton(app, colors[i]));
        }

        HBox label = new HBox(new Label("Color"));
        label.setAlignment(Pos.CENTER);
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        this.getChildren().addAll(spacer, label);
    }
}