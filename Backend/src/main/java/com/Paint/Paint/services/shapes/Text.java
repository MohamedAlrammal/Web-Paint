package com.Paint.Paint.services.shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("text")
public class Text extends shape {
    private String text;
    private double fontFamily;

    public Text(ShapeDTO docreate) {
        super(docreate);
        this.text = docreate.text;
        this.fontFamily = docreate.fontFamily;
    }
    
    public Text(Text s) {
        super(s);
        this.text = s.text;
        this.fontFamily = s.fontFamily;
    }

    @Override
    public shape clone(String cloneid) throws CloneNotSupportedException {
        Text clonesquare = new Text(this);
        clonesquare.setId(cloneid);
        return clonesquare;
    }



   

    
}
