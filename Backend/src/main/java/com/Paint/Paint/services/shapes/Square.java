package com.Paint.Paint.services.shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("square")
public class Square extends shape {
    private double width;
    private double height;
    
    public Square(Shapecreate docreate) {
        super(docreate);
        this.width = docreate.width;
        this.height = docreate.height;
    }
    
    public Square(Square s) {
        super(s);
        this.width = s.width;
        this.height = s.height;
    }
    
    public Square() {}
    
    public double getWidth() {
        return width;
    }
    
    public void setWidth(double width) {
        this.width = width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public Square clone(String cloneid) throws CloneNotSupportedException {
        Square clonesquare = new Square(this);
        clonesquare.setId(cloneid);
        return clonesquare;
    }
}
