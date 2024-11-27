package com.Paint.Paint.services.shapes;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("triangle")
public class Triangle extends shape {
    private double radius;
    private final int sides = 3;
    public Triangle (ShapeDTO t){
        super(t);
        this.radius = t.radius ;
    }
    public Triangle(Triangle t){
        super(t);
        this.radius = t.radius ;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public int getSides() {
        return sides;
    }

    @Override
    public shape clone(String cloneid) throws CloneNotSupportedException {
        Triangle clonesquare = new Triangle(this);
        clonesquare.setId(cloneid);
        return clonesquare;
    }
}
 