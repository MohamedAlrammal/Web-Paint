package com.Paint.Paint.services.shapes;
import com.fasterxml.jackson.annotation.JsonTypeName;
@JsonTypeName("rectangle")
public class Rectangle extends shape {
    private double width;
    private double height;
    
    public Rectangle(Shapecreate l) {
        super(l);
        this.width = l.width;
        this.height =l.height;
    }
    public Rectangle(Rectangle l) {
        super(l);
        this.width = l.width;
        this.height =l.height;
    }
    public Rectangle(){}
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    } 
    public void setWidth(double width) {
        this.width = width;
    } 
    public void setHeight(double height) {
        this.height = height;
    } 
    @Override
    public Rectangle clone(String cloneid) throws CloneNotSupportedException {
        Rectangle clonesquare = new Rectangle(this);
        clonesquare.setId(cloneid);
        return clonesquare;
    }
}
