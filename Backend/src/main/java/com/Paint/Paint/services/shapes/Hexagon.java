package com.Paint.Paint.services.shapes;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("hexagon")
public class Hexagon extends shape {
    private double radius;
    private final int sides = 6;
    public Hexagon (ShapeDTO t){
        super(t);
        this.radius = t.radius ;
    }
    public Hexagon(Hexagon t){
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
        Hexagon clonesquare = new Hexagon(this);
        clonesquare.setId(cloneid);
        return clonesquare;
    }
}
 