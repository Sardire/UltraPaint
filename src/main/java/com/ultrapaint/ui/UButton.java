package com.ultrapaint.ui;

import javafx.scene.control.*;
import com.ultrapaint.constants.*;

public class UButton extends Button{
    public UButton(ToolID toolId){
        this.setMaxWidth(40);
        this.setGraphic(toolId.getFontIcon());
    }
    public UButton(){
        super();
        this.setMaxWidth(40);
    }
}