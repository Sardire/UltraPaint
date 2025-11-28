package com.ultrapaint.ui.box;

import com.ultrapaint.App;
import com.ultrapaint.ui.button.UBrushButton;
import com.ultrapaint.ui.button.UEraserButton;
import com.ultrapaint.ui.textfield.EraserSizeTF;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class UEraserBox extends VBox {
    public UEraserBox(App app){
        super(new UEraserButton(app), new EraserSizeTF(app, "Size"));
        HBox label = new HBox(new Label("Eraser"));
        label.setAlignment(Pos.CENTER);
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        this.getChildren().addAll(spacer, label);
    }
}
