package com.ultrapaint.ui.box;

import com.ultrapaint.App;
import com.ultrapaint.ui.button.UColorPickerButton;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class UColorPickerBox extends VBox {
    public UColorPickerBox(App app){
        super();

        UColorPickerButton btn = new UColorPickerButton(app);

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        Label label = new Label("Color picker");

        this.getChildren().addAll(btn, spacer, label);
        this.setAlignment(Pos.CENTER);
    }
}
