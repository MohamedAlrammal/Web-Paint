package com.Paint.Paint.services.shapes;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("hexagon")
public class Hexagon extends shape {
    private double radius;
    private int sides;
    public Hexagon (ShapeDTO t){
        super(t);
        this.radius = t.radius ;
        this.sides = t.sides ;
    }
    public Hexagon(Hexagon t){
        super(t);
        this.radius = t.radius ;
        this.sides = t.sides ;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public int getSides() {
        return 6;
    }
    public void setSides(int sides) {
        this.sides = sides;
    }

    @Override
    public shape clone(String cloneid) throws CloneNotSupportedException {
        Hexagon clonesquare = new Hexagon(this);
        clonesquare.setId(cloneid);
        return clonesquare;
    }
}
 