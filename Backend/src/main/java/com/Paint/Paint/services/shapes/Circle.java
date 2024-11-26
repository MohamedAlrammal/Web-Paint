package com.Paint.Paint.services.shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("circle")
public class Circle extends shape {
    private double radius;
    
    public Circle(Shapecreate rad) {
        super(rad);
        this.radius = rad.radius;
    }
    
    public Circle(Circle rad) {
        super(rad);
        this.radius = rad.radius;
    }
    public Circle() {

}

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
  
    @Override
    public Circle clone(String cloneid) throws CloneNotSupportedException {
        Circle clonesquare = new Circle(this);
        clonesquare.setId(cloneid);
        return clonesquare;
    }

}
