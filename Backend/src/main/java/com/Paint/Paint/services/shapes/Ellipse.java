package com.Paint.Paint.services.shapes;
import com.fasterxml.jackson.annotation.JsonTypeName;
@JsonTypeName("ellipse")
public class Ellipse extends shape {
    private double radiusX;
    private double radiusY;
    private final String Konvaname = "Ellipse";

    public Ellipse() {
        super();
    }

    public Ellipse(ShapeDTO e) {
        super(e);
        this.radiusX = e.radiusX;
        this.radiusY = e.radiusY;
    }
    public Ellipse(Ellipse e){
        super(e);
        this.radiusX = e.radiusX;
        this.radiusY = e.radiusY;
    }
    @Override
    public void update(ShapeDTO dto){
        super.update(dto);
        this.radiusX = dto.radiusX ;
        this.radiusY = dto.radiusY ;
    }
    public double getRadiusX() {
        return radiusX;
    }
    public String getKonvaname(){
        return Konvaname;
     }
    public double getRadiusY() {
        return radiusY;
    }

    public void setRadiusX(double radiusX) {
        this.radiusX = radiusX;
    }

    public void setRadiusY(double radiusY) {
        this.radiusY = radiusY;
    }
    @Override
    public shape clone(String cloneid) throws CloneNotSupportedException {
        Ellipse clonesquare = new Ellipse(this);
        clonesquare.setId(cloneid);
        return clonesquare;
    }
}
