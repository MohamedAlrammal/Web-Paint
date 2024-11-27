package com.Paint.Paint.services.shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("circle")
public class Circle extends shape {
    private double radius;
    
    public Circle(ShapeDTO rad) {
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
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        this.radius = radius;
    }
    @Override
    public shape clone(String cloneId) throws CloneNotSupportedException {
        Circle clonedCircle = new Circle(this);
        clonedCircle.setId(cloneId);
        return clonedCircle;
    }
}

