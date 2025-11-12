package com.ultrapaint.ui.textfield;


import com.ultrapaint.App;

public class LineSizeTF extends BaseTF{
    public LineSizeTF(App app, String text){
        super(app, text);

        this.setText("1.0");
        this.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                if (this.getText().isEmpty()) {
                    app.currentLineSize = 1.0;
                    this.setText("1.0");
                }
                else {
                    app.currentLineSize = Double.parseDouble(this.getText());
                }
            }
        });
    }
}
