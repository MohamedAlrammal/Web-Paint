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
    public double rotation = 0;
    public boolean draggable = true;
    public double scaleofY = 0;
    public double scaleofX = 0;
    public double scaleY = 1;
    public double scaleX = 1;
    public double skewY = 0;
    public double skewX = 0;
    public String stroke = "black";
    public double strokeWidth = 4;
    public String fill = "white";
    public double radiusX = 0;
    public double radiusY = 0;
    public double width = 0;
    public double height = 0;
    public double radius = 0;
    public int sides = 0;
    public ArrayList<Double> points = new ArrayList<>() ;
    public double tension = 0;
    public String fontFamily = "Calibri";
    public String text = "Enter Text";
    public double fontSize = 18;
    public String Konvaname;
}
