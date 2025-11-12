package com.ultrapaint.ui.textfield;

import com.ultrapaint.App;

public class BrushSizeTF extends BaseTF{
    public BrushSizeTF(App app, String text){
        super(app, text);

        this.setText("5.0");
        this.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                if (this.getText().isEmpty()) {
                    app.currentBrushSize = 5.0;
                    this.setText("5.0");
                }
                else {
                    app.currentBrushSize = Double.parseDouble(this.getText());
                }
            }
        });
    }
}
