package com.ultrapaint.ui.box;

import com.ultrapaint.App;

import com.ultrapaint.ui.button.UColorButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class UColorBox extends HBox {
    Color[] colors = {
        Color.BLACK, Color.DARKGRAY, Color.GRAY,
        Color.LIGHTGRAY, Color.WHITE, Color.RED,
        Color.ORANGE, Color.YELLOW, Color.GREEN,
        Color.BLUE, Color.INDIGO, Color.VIOLET
    };
    public UColorBox(App app){
        super();
        app.toolbar.getItems().add(this);

        for (int i = 0;i < (colors.length + 2) / 3;i++) {
            VBox vbox = new VBox();
            this.getChildren().add(vbox);
        }
        
        for (int i = 0;i < colors.length;i++) {
            VBox vbox = (VBox)this.getChildren().get(i / 3);
            vbox.getChildren().add(new UColorButton(app, colors[i]));
        }
    }
}