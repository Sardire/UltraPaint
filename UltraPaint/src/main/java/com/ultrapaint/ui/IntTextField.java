package com.ultrapaint.ui;

import javafx.scene.control.*;
import javafx.scene.control.TextFormatter.Change;
import java.util.function.UnaryOperator;
import com.ultrapaint.App;

public class IntTextField extends TextField {
    public IntTextField(App app, String text) {
        super();
        this.setPromptText(text);
        UnaryOperator<Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        };
        this.setMaxWidth(40);
        this.setTextFormatter(new TextFormatter<>(integerFilter));
    }
}