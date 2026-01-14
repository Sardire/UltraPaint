package com.ultrapaint.ui.button;

import com.ultrapaint.App;
import com.ultrapaint.constants.ToolID;

public class UColorPickerButton extends UButton{
    public UColorPickerButton(App app){
        super();
        this.setGraphic(ToolID.COLORPICKER.getFontIcon());
        setOnMouseClicked(e -> {
            app.colorPickerTool.setBehavior(app);
        });
    }
}
