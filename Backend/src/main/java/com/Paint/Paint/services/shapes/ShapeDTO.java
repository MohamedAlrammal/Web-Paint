package com.Paint.Paint.services.shapes;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_DEFAULT) 
public class ShapeDTO {  //  data transfer object (DTO) 
    public String id;
    public String name;
    public double x ;
    public double y ;
    public double rotation;
    public boolean draggable=true;
    public double scaleofY ;
    public double scaleofX ;
    public String stroke ;
    public double strokeWidth ;
    public String fill ;
    public double radiusX; 
    public double radiusY; 
    public double width ; 
    public double height ; 
    public double radius ;
    public int sides;
    public ArrayList<Double> points = new ArrayList<>() ;
    public double tension;
    public boolean closed ;
    public String fontFamily;
    public String text;
    public double fontSize;
    public double sidelength;
    public String Konvaname;
}
