package com.ultrapaint.ui;

import com.ultrapaint.App;

import com.ultrapaint.ui.box.*;

import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.paint.Color;


public class UToolBar extends ToolBar{
    public UBrushBox brushBox;
    public UEraserBox eraserBox;
    public UColorBox colorBox;
    public UShaperBox shaperBox;
    public UBucketBox bucketBox;
    public UCurrentColorBox currentColorBox;
    public URGBBox RGBBox;
    public UFlipBox flipBox;
    public UColorPickerBox colorPickerBox;
    public App app;
    public UToolBar(App a){
        super();
        app = a;
        brushBox = new UBrushBox(app);
        eraserBox = new UEraserBox(app);
        colorBox = new UColorBox(app);
        shaperBox = new UShaperBox(app);
        bucketBox = new UBucketBox(app);
        currentColorBox = new UCurrentColorBox(app);
        RGBBox = new URGBBox(app);
        flipBox = new UFlipBox(app);
        colorPickerBox = new UColorPickerBox(app);

        this.setMinHeight(120);
        this.getItems().addAll(
                brushBox, new Separator(),
                bucketBox, new Separator(),
                eraserBox, new Separator(),
                colorPickerBox, new Separator(),
                colorBox, new Separator(),
                currentColorBox, new Separator(),
                shaperBox, new Separator(),
                RGBBox, new Separator(),
                flipBox);
    }

    public void setColor(Color color){
        app.currentColor = color;
        currentColorBox.circle.setFill(color);
    }
}