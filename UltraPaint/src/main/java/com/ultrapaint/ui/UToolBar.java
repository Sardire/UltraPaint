package com.ultrapaint.ui;

import com.ultrapaint.App;
import com.ultrapaint.constants.ToolID;

import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;


public class UToolBar extends ToolBar{
    public UToolBar(App app){
        super(
            new VBox(new UButton(ToolID.BRUSH), new IntTextField(app, "Size")),
            new VBox(new UButton(ToolID.ERASER), new IntTextField(app, "Size"))
        );

        IntTextField brushSize = (IntTextField)((VBox)this.getItems().get(ToolID.BRUSH.getId())).getChildren().get(1);
        IntTextField eraserSize = (IntTextField)((VBox)this.getItems().get(ToolID.ERASER.getId())).getChildren().get(1);
        brushSize.setText("5");
        eraserSize.setText("10");
        brushSize.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                if (brushSize.getText().isEmpty()) {
                    app.currentBrushSize = 5;
                    brushSize.setText("5");
                }
                else {
                    app.currentBrushSize = Integer.parseInt(brushSize.getText());
                }
            }
        });
        eraserSize.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                if (eraserSize.getText().isEmpty()) {
                    app.currentEraserSize = 10;
                    eraserSize.setText("10");
                }
                else {
                    app.currentEraserSize = Integer.parseInt(eraserSize.getText());
                }
                app.eraserTool.eraserPreview.setWidth(app.currentEraserSize);
                app.eraserTool.eraserPreview.setHeight(app.currentEraserSize);
            }
        });

        ((VBox)this.getItems().get(ToolID.ERASER.getId())).getChildren().get(0).setOnMouseClicked(e -> {
            app.eraserTool.setBehavior(app);
        });

        ((VBox)this.getItems().get(ToolID.BRUSH.getId())).getChildren().get(0).setOnMouseClicked(e -> {
            app.brushTool.setBehavior(app);
        });
    }
}