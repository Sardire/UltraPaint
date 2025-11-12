package com.ultrapaint.core.toolpreview;

import com.ultrapaint.App;

public abstract class Preview {
    public abstract void setOnPressed(App app, double x, double y);
    public abstract void setOnMoved(App app, double x, double y);
    public abstract void setOnDragged(App app, double x, double y);
    public abstract void setOnReleased(App app, double x, double y);
    public abstract void setVisible(boolean state);
}
