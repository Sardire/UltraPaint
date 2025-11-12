package com.ultrapaint.constants;

public enum ShapeID {
    RECTANGLE(0),
    LINE(1),
    ELLIPSE(2);

    private final int id;

    ShapeID(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
}
