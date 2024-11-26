package com.Paint.Paint.services.shapes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Circle.class, name = "circle"),
    @JsonSubTypes.Type(value = Rectangle.class, name = "rectangle"),
    @JsonSubTypes.Type(value = Triangle.class, name = "triangle"),
    @JsonSubTypes.Type(value = Elipse.class, name = "ellipse")
 
})
@JsonIgnoreProperties(value = "attributes" ,ignoreUnknown = true)
public abstract class shape implements Cloneable{// clonable 
    private String id;
    private String name ;
    private double x ;
    private double y ;
    private boolean draggable ;
    private double scaleofY ;
    private double scaleofX ;
    private String fill;
    public shape(Shapecreate docreate) {
        this.x = docreate.x ;
        this.y = docreate.y ;
        this.id = docreate.id ;
        this.fill = docreate.fill ;
        this.name = docreate.name ;
        this.draggable = docreate.draggable ;
        this.scaleofX = docreate.scaleofX ;
        this.scaleofY = docreate.scaleofY ;
    }
    public shape(shape s){ //copy
        this.id = s.id ;
        this.name = s.name ;
        this.x = s.x ;
        this.y = s.y ;
        this.draggable = s.draggable ;
        this.scaleofX = s.scaleofX ;
        this.scaleofY = s.scaleofY ;
        this.fill = s.fill ;
    }
    public abstract shape clone(String cloneid)throws CloneNotSupportedException;

    public shape(){
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
