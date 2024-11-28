package com.Paint.Paint.services.shapes;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Line")
public class Line extends shape {
    private ArrayList<Double> points;
    private final String Konvaname = "Line";
    private double tension;
    public Line(ShapeDTO l) {
        super(l);  // Initialize parent class fields
        if (l.points != null) {
            this.points = new ArrayList<>(l.points);
        } else {
            this.points = new ArrayList<>();
        }
        this.tension = l.tension;
    }
    public Line() {
        this.points = new ArrayList<>();
    }
    public Line(Line l) {
        super(l);
        this.points = new ArrayList<>(l.points);
        this.tension = l.tension;
    }
    public String getKonvaname() {
        return Konvaname;
    }
    public ArrayList<Double> getPoints() {
        return points;
    }
    public void setPoints(ArrayList<Double> points) {
        this.points = points;
    }
    public double getTension() {
        return tension;
    }
    public void setTension(double tension) {
        this.tension = tension;
    }
    @Override
    public shape clone(String cloneid) throws CloneNotSupportedException {
        Line clonedLine = new Line(this);
        clonedLine.setId(cloneid);
        return clonedLine;
    }

}