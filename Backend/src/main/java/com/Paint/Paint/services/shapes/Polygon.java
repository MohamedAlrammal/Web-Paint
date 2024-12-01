package com.Paint.Paint.services.shapes;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("polygon")
public class Polygon extends shape {
    private double radius;
    private int sides;

    public Polygon (ShapeDTO j){
        super(j);
        this.radius = j.radius ;
        this.sides = j.sides ;
    }
    public Polygon(Polygon t){
        super(t);
        this.radius = t.radius ;
        this.sides = t.sides ;
    }
    @Override
    public void update(ShapeDTO dto){
        super.update(dto);
        this.radius = dto.radius ;
        this.sides = dto.sides ;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public int getSides() {
        return 4;
    }
    public void setSides(int sides) {
        this.sides = sides;
    }

    @Override
    public shape clone(String cloneid) throws CloneNotSupportedException {
        Polygon clonesquare = new Polygon(this);
        clonesquare.setId(cloneid);
        return clonesquare;
    }
}
 