package com.ultrapaint.ui;

import com.ultrapaint.App;
import com.ultrapaint.constants.ToolID;

import com.ultrapaint.ui.button.UBrushButton;
import com.ultrapaint.ui.button.UEraserButton;
import com.ultrapaint.ui.textfield.BaseTF;
import com.ultrapaint.ui.textfield.BrushSizeTF;
import com.ultrapaint.ui.textfield.EraserSizeTF;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;


public class UToolBar extends ToolBar{
    public UToolBar(App app){
        super(
            new VBox(new UBrushButton(app), new BrushSizeTF(app, "Size")),
            new VBox(new UEraserButton(app), new EraserSizeTF(app, "Size"))
        );
    }
}