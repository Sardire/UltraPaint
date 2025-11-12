package com.ultrapaint.ui.textfield;

import com.ultrapaint.App;

public class EraserSizeTF extends BaseTF{
    public EraserSizeTF(App app, String text){
        super(app, text);

        this.setText("10.0");
        this.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                if (this.getText().isEmpty()) {
                    app.currentEraserSize = 10;
                    this.setText("10.0");
                }
                else {
                    app.currentEraserSize = Double.parseDouble(this.getText());
                }
                app.eraserTool.eraserPreview.resize(app.currentEraserSize);
            }
        });
    }
}
