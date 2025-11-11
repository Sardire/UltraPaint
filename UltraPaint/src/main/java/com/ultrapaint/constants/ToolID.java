package com.ultrapaint.constants;

import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;

public enum ToolID {
    BRUSH(0),
    ERASER(1),
    COLOR(2);

    private final int id;
    private final FontIcon fontIcon;

    ToolID(int id) {
        this.id = id;
        switch (this) {
            case BRUSH -> this.fontIcon = new FontIcon(FontAwesomeSolid.PAINT_BRUSH);
            case ERASER -> this.fontIcon = new FontIcon(FontAwesomeSolid.ERASER);
            default -> this.fontIcon = null;
        }
    }

    public int getId() {
        return id;
    }

    public FontIcon getFontIcon() {
        return fontIcon;
    }
}