package com.ultrapaint.ui.button;

import com.ultrapaint.App;
import com.ultrapaint.constants.ToolID;

public class UBrushButton extends UButton{

    public UBrushButton(App app){
        super();
        this.setGraphic(ToolID.BRUSH.getFontIcon());
        this.setOnMouseClicked(e -> {
            app.brushTool.setBehavior(app);
        });
    }
}
