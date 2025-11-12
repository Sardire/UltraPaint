package com.ultrapaint.ui.button;

import com.ultrapaint.App;
import com.ultrapaint.constants.ToolID;

public class UEraserButton extends UButton{

    public UEraserButton(App app){
        super();
        this.setGraphic(ToolID.ERASER.getFontIcon());
        this.setOnMouseClicked(e -> {
            app.eraserTool.setBehavior(app);
        });
    }
}
