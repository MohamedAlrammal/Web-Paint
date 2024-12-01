package com.Paint.Paint.services.shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Circle")
public class Circle extends shape {
    private double radius;
    private final String Konvaname = "Circle";
    
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
    @Override
    public void update(ShapeDTO dto){
         super.update(dto);
        this.radius = dto.radius ;
    }
     public String getKonvaname(){
        return Konvaname;
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

