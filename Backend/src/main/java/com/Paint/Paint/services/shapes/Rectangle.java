package com.Paint.Paint.services.shapes;
import com.fasterxml.jackson.annotation.JsonTypeName;
@JsonTypeName("Rect")
public class Rectangle extends shape {
    private double width;
    private double height;
    private final String Konvaname = "Rect";
    
    public Rectangle(ShapeDTO l) {
        super(l);
        this.width = l.width;
        this.height =l.height;
    }
    public Rectangle(Rectangle l) {
        super(l);
        this.width = l.width;
        this.height =l.height;
    }
    @Override
    public void update(ShapeDTO dto){
        super.update(dto);
        this.width = dto.width ;
        this.height = dto.height ;
    }
    public Rectangle(){}
    public double getWidth() {
        return width;
    }
    public String getKonvaname(){
        return Konvaname;
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
