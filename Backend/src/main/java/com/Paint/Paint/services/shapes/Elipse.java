package com.Paint.Paint.services.shapes;
import com.fasterxml.jackson.annotation.JsonTypeName;
@JsonTypeName("elipse")
public class Elipse extends shape {
    private double radiusX;
    private double radiusY;
    public Elipse(Shapecreate e) {
        super(e);
        this.radiusX = e.radiusX;
        this.radiusY = e.radiusY;
    }
    public Elipse(Elipse s){
        super(s);
        this.radiusX=s.getScaleofX();
        this.radiusY=s.getScaleofY();
    }
    public double getRadiusX() {
        return radiusX;
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
    public Elipse clone(String cloneid) throws CloneNotSupportedException {
        Elipse clonesquare = new Elipse(this);
        clonesquare.setId(cloneid);
        return clonesquare;
    }
}
