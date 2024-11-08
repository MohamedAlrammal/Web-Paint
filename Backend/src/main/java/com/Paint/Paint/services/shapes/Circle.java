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





}
