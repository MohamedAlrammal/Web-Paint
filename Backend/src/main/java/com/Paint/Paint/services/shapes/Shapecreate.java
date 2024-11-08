package com.Paint.Paint.services.shapes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_DEFAULT) 
public class Shapecreate {  //  data transfer object (DTO) 
    public String id;
    public String name ;
    public double x ;
    public double y ;
    public boolean draggable ;
    public double scaleofY ;
    public double scaleofX ;
    public String fill;
    public double radiusX; 
    public double radiusY; 
    public double width ; 
    public double height ; 
    public double radius ;
    public int sides;
}
