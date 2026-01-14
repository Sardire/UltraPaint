package com.ultrapaint.ui.box;

import com.ultrapaint.App;
import com.ultrapaint.ui.button.UHFlipButton;
import com.ultrapaint.ui.button.UVFlipButton;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class UFlipBox extends VBox {
    UHFlipButton hFlipButton;
    UVFlipButton vFlipButton;
    public UFlipBox(App app){
        super();
        hFlipButton = new UHFlipButton(app);
        vFlipButton = new UVFlipButton(app);
        hFlipButton.setText("Flip horizontal");
        vFlipButton.setText("Flip vertical");
        hFlipButton.setMaxWidth(Double.MAX_VALUE);
        vFlipButton.setMaxWidth(Double.MAX_VALUE);

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        Label label = new Label("Flipper");

        this.getChildren().addAll(hFlipButton, vFlipButton, spacer, label);
        this.setAlignment(Pos.CENTER);
    }
}
