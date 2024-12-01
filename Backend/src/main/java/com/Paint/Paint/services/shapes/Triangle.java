package com.Paint.Paint.services.shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("triangle")
public class Triangle extends shape {
    private double radius;
    private final String Konvaname = "RegularPolygon";
    private final int sides = 3;

    public Triangle() {
        super();
    }

    public Triangle(ShapeDTO t) {
        super(t);
        this.radius = t.radius;
    }

    public String getKonvaname() {
        return Konvaname;
    }

    public Triangle(Triangle t) {
        super(t);
        this.radius = t.radius;
    }
    @Override
    public void update(ShapeDTO dto){
        super.update(dto);
        this.radius = dto.radius ;
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
        Triangle clonedTriangle = new Triangle(this);
        clonedTriangle.setId(cloneid);
        return clonedTriangle;
    }
}
