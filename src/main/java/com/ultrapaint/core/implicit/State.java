package com.ultrapaint.core.implicit;

import javafx.scene.image.WritableImage;

public class State {
    public WritableImage img;
    public State prev;
    public State next;
    public State(){
        this.img = null;
        this.prev = null;
        this.next = null;
    }

    public State(WritableImage img){
        this.img = img;
        this.prev = null;
        this.next = null;
    }
}
