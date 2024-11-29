package com.Paint.Paint.services.shapes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Circle.class, name = "Circle"),
    @JsonSubTypes.Type(value = Square.class, name = "square"),
    @JsonSubTypes.Type(value = Rectangle.class, name = "Rect"),
    @JsonSubTypes.Type(value = Line.class, name = "line"),
    @JsonSubTypes.Type(value = Triangle.class, name = "triangle"),
    @JsonSubTypes.Type(value = Polygon.class, name = "polygon"),
    @JsonSubTypes.Type(value = Hexagon.class, name = "hexagon"),
    @JsonSubTypes.Type(value = Ellipse.class, name = "ellipse")
 
})
@JsonIgnoreProperties(value = "attributes" ,ignoreUnknown = true)
public abstract class shape implements Cloneable{// clonable 
    private String id;
    private String name;
    private double x;
    private double y;
    private double rotation;
    private boolean draggable;
    private double scaleofY;
    private double scaleofX;
    private String stroke;
    private double strokeWidth;
    private double fontFamily;
    private String text;
    private String Konvaname;

    private String fill;
    public shape(ShapeDTO docreate) {
        this.x = docreate.x ;
        this.y = docreate.y ;
        this.id = docreate.id ;
        this.fill = docreate.fill ;
        this.name = docreate.name ;
        this.stroke = docreate.stroke ;
        this.Konvaname=docreate.Konvaname;
        this.strokeWidth = docreate.strokeWidth ;
        this.rotation = docreate.rotation ;
        this.draggable = docreate.draggable ;
        this.scaleofX = docreate.scaleofX ;
        this.scaleofY = docreate.scaleofY ;
    }
    public shape(shape s){ //copy
        this.id = s.id ;
        this.name = s.name ;
        this.x=s.x+10 ;
        this.y=s.y+10 ;
        this.draggable = s.draggable ;
        this.scaleofX = s.scaleofX ;
        this.scaleofY = s.scaleofY ;
        this.stroke = s.stroke ;
        this.strokeWidth = s.strokeWidth ;
        this.fill = s.fill ;
    }
    public abstract shape clone(String cloneid)throws CloneNotSupportedException;

    public shape(){
    }
    public String getKonvaname() {
        return Konvaname;
    }
    public void setKonvaname(String stroke) {
        this.Konvaname = Konvaname;
    }
    public String getStroke() {
        return stroke;
    }
    public void setStroke(String stroke) {
        this.stroke = stroke;
    }
    public double getStrokeWidth() {
        return strokeWidth;
    }
    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getRotation() {
        return rotation;
    }
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public boolean isDraggable() {
        return draggable;
    }
    public void setDraggable(boolean draggable) {
        this.draggable = draggable;
    }
    public double getScaleofY() {
        return scaleofY;
    }
    public void setScaleofY(double scaleofY) {
        this.scaleofY = scaleofY;
    }
    public double getScaleofX() {
        return scaleofX;
    }
    public void setScaleofX(double scaleofX) {
        this.scaleofX = scaleofX;
    }
    public String getFill() {
        return fill;
    }
    public void setFill(String fill) {
        this.fill = fill;
    }

}
