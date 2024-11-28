package com.Paint.Paint.services.shapes;
import com.fasterxml.jackson.annotation.JsonTypeName;
@JsonTypeName("elipse")
public class Elipse extends shape {
    private double radiusX;
    private double radiusY;
    private final String Konvaname = "Elipse";
    public Elipse(ShapeDTO e) {
        super(e);
        this.radiusX = e.radiusX;
        this.radiusY = e.radiusY;
    }
    public Elipse(Elipse e){
        super(e);
        this.setRadiusX(e.getScaleofX());
        this.setRadiusY(e.getScaleofY());
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
        Elipse clonesquare = new Elipse(this);
        clonesquare.setId(cloneid);
        return clonesquare;
    }
}
