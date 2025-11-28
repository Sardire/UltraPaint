package com.ultrapaint.ui.box;

import com.ultrapaint.App;
import com.ultrapaint.ui.button.UBrushButton;
import com.ultrapaint.ui.textfield.BrushSizeTF;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class UBrushBox extends VBox {
    public UBrushBox(App app){
        super(new VBox(new UBrushButton(app), new BrushSizeTF(app, "Size")));
        HBox label = new HBox(new Label("Brush"));
        label.setAlignment(Pos.CENTER);
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        this.getChildren().addAll(spacer, label);
    }
}
