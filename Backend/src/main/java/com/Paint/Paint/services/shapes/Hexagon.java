package com.Paint.Paint.services.shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("hexagon") 
public class Hexagon extends shape {
    private double radius; 
    private final int sides = 6; 
    private final String Konvaname = "RegularPolygon"; 
    public Hexagon() {
        super();
    }

    public Hexagon(ShapeDTO t) {
        super(t);
        this.radius = t.radius;
    }

    public Hexagon(Hexagon h) {
        super(h);
        this.radius = h.radius;
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
    // Getter for Konvaname
    public String getKonvaname() {
        return Konvaname;
    }
    @Override
    public shape clone(String cloneid) throws CloneNotSupportedException {
        Hexagon clonedHexagon = new Hexagon(this);
        clonedHexagon.setId(cloneid);
        return clonedHexagon;
    }
}
