package com.ultrapaint.ui.box;

import com.ultrapaint.constants.ShapeID;
import com.ultrapaint.ui.button.UShaperButton;
import javafx.scene.layout.HBox;
import com.ultrapaint.App;
import javafx.scene.layout.VBox;

public class UShaperBox extends HBox {
    ShapeID[] shapeList = {
            ShapeID.RECTANGLE, ShapeID.LINE, ShapeID.ELLIPSE,
    };
    public UShaperBox(App app){
        super();
        app.toolbar.getItems().add(this);

        for (int i = 0;i < shapeList.length; i++){
            VBox vBox = new VBox();
            this.getChildren().add(vBox);
        }

        for (int i = 0; i < shapeList.length;i++){
            VBox currentVBox = (VBox)this.getChildren().get(i / 3);
            UShaperButton shapeButton = new UShaperButton(app, shapeList[i]);
            currentVBox.getChildren().add(shapeButton);
        }
    }
}
