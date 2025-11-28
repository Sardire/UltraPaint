package com.ultrapaint.ui.box;

import com.ultrapaint.constants.ShapeID;
import com.ultrapaint.ui.button.UShaperButton;
import com.ultrapaint.ui.textfield.LineSizeTF;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import com.ultrapaint.App;

public class UShaperBox extends VBox {
    ShapeID[] shapeList = {
            ShapeID.RECTANGLE, ShapeID.LINE, ShapeID.ELLIPSE,
    };
    public UShaperBox(App app){
        super();

        for (int i = 0;i < shapeList.length; i++){
            HBox hBox = new HBox();
            this.getChildren().add(hBox);
        }

        for (int i = 0; i < shapeList.length;i++){
            HBox currentHBox = (HBox)this.getChildren().get(i / 3);
            UShaperButton shapeButton = new UShaperButton(app, shapeList[i]);
            currentHBox.getChildren().add(shapeButton);
        }

        HBox ltf = new HBox(new LineSizeTF(app, "Size"));
        HBox label = new HBox(new Label("Shape"));
        ltf.setAlignment(Pos.CENTER);
        label.setAlignment(Pos.CENTER);
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        this.getChildren().addAll(ltf, spacer, label);
    }
}
