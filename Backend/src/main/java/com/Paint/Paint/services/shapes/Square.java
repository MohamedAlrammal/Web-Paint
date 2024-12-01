package com.Paint.Paint.services.shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("square")
public class Square extends shape {
    private double width;
    private double height;
    private final String Konvaname = "Rect";

 
    public Square(ShapeDTO docreate) {
        super(docreate);
        this.width = docreate.width;
        this.height = docreate.height;
    }
    
    public Square(Square s) {
        super(s);
        this.width = s.width;
        this.height = s.height;
    }
    public String getKonvaname(){
        return Konvaname;
     }
    @Override
    public void update(ShapeDTO dto){
        super.update(dto);
        this.width = dto.width ;
        this.height = dto.height ;
    }
    
    public Square() {}
    
    public double getWidth() {
        return height;
    }
    
    public void setWidth(double width) {
        this.width = height;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public Square clone(String cloneid) throws CloneNotSupportedException {
        Square clonesquare = new Square(this);
        clonesquare.setId(cloneid);
        return clonesquare;
    }
}
