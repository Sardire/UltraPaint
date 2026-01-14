package com.ultrapaint.ui.button;

import com.ultrapaint.App;
import com.ultrapaint.constants.ToolID;

public class UBucketFillButton extends UButton{
    public UBucketFillButton(App app){
        super();
        this.setGraphic(ToolID.BUCKET.getFontIcon());
        this.setOnMouseClicked(e -> {
            app.bucketTool.setBehavior(app);
        });
    }
}
