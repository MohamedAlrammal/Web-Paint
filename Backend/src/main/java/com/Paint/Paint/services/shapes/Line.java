package com.Paint.Paint.services.shapes;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonTypeName;


@JsonTypeName("line")
public class Line extends shape{
    private ArrayList<Double> points;
    public Line (ShapeDTO l) {
        super(l);
        this.points = l.points ;
    }
    public Line () {}
    public Line (Line l) {
        super(l);
        this.points = l.points ;
    }
    public ArrayList<Double> getPoints() {
        return points;
    }
    public void setPoints(ArrayList<Double> points) {
        this.points = points;
    }

    @Override
    public Line clone( String idNew)throws CloneNotSupportedException{
        Line newShape = new Line(this);
        newShape.setId(idNew);
        newShape.setY(newShape.getY()-20);
        return newShape ;
    }
}
