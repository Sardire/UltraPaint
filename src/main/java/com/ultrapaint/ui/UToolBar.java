package com.ultrapaint.ui;

import com.ultrapaint.App;

import com.ultrapaint.ui.box.UBrushBox;
import com.ultrapaint.ui.box.UColorBox;
import com.ultrapaint.ui.box.UEraserBox;
import com.ultrapaint.ui.box.UShaperBox;

import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;


public class UToolBar extends ToolBar{
    public UToolBar(App app){
        super();
        UBrushBox brushBox = new UBrushBox(app);
        UEraserBox eraserBox = new UEraserBox(app);
        UColorBox colorBox = new UColorBox(app);
        UShaperBox shaperBox = new UShaperBox(app);

//        brushBox.prefHeightProperty().bind(this.heightProperty());
//        eraserBox.prefHeightProperty().bind(this.heightProperty());
//        colorBox.prefHeightProperty().bind(this.heightProperty());
//        shaperBox.prefHeightProperty().bind(this.heightProperty());
        this.setMinHeight(120);
        this.getItems().addAll(brushBox, new Separator(), eraserBox, new Separator(), colorBox, new Separator(), shaperBox);
    }
}