package com.ultrapaint.ui.box;

import com.ultrapaint.App;
import com.ultrapaint.ui.button.UBrushButton;
import com.ultrapaint.ui.button.UBucketFillButton;
import com.ultrapaint.ui.textfield.BrushSizeTF;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class UBucketBox extends VBox {
    public UBucketBox(App app){
        super();;
        VBox btn = new VBox(new UBucketFillButton(app));
        HBox label = new HBox(new Label("Bucketfill"));
        label.setAlignment(Pos.CENTER);
        btn.setAlignment(Pos.CENTER);
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        this.getChildren().addAll(btn, spacer, label);
    }
}