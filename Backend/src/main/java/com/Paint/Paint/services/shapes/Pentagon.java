package com.Paint.Paint.services.shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("pentagon")
public class Pentagon extends shape {
    private double radius;
    private final int sides = 5;
    private final String Konvaname = "RegularPolygon";
    public Pentagon() {
        super();
    }

    public Pentagon(ShapeDTO t) {
        super(t);
        this.radius = t.radius;
    }

    public Pentagon(Pentagon p) {
        super(p);
        this.radius = p.radius;
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
    // Getter for Konvaname
    public String getKonvaname() {
        return Konvaname;
    }
    @Override
    public shape clone(String cloneid) throws CloneNotSupportedException {
        Pentagon clonedPentagon = new Pentagon(this);
        clonedPentagon.setId(cloneid);
        return clonedPentagon;
    }
}