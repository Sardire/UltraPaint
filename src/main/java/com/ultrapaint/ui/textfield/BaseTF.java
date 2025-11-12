package com.ultrapaint.ui.textfield;

import javafx.scene.control.*;
import javafx.scene.control.TextFormatter.Change;
import java.util.function.UnaryOperator;
import com.ultrapaint.App;

public class BaseTF extends TextField {
    String pattern = "\\d*(\\.\\d{0,1})?";
    public BaseTF(App app, String text) {
        super();
        this.setPromptText(text);
        UnaryOperator<Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches(pattern)) {
                return change;
            }
            return null;
        };
        this.setMaxWidth(40);
        this.setTextFormatter(new TextFormatter<>(filter));
    }
}