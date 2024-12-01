package com.Paint.Paint.services.shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("text")
public class Text extends shape {
    private String text;
    private final String Konvaname = "Text";
    private String fontFamily;
    private double fontSize;
    private double width;
    private double height;

    public double getFontSize() {
        return fontSize;
    }

    public void setFontSize(double fontSize) {
        this.fontSize = fontSize;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Text(ShapeDTO docreate) {
        super(docreate);
        this.text = docreate.text;
        this.fontFamily = docreate.fontFamily;
        this.fontSize =docreate.fontSize;
        this.width = docreate.width;
        this.height =docreate.height;
    }
    
    public Text(Text s) {
        super(s);
        this.text = s.text;
        this.fontFamily = s.fontFamily;
        this.fontSize = s.fontSize;
        this.width = s.width;
        this.height =s.height;
    }

    @Override
    public void update(ShapeDTO dto){
        super.update(dto);
        this.width = dto.width ;
        this.height = dto.height ;
        this.fontSize = dto.fontSize ;
        this.fontFamily = dto.fontFamily ;
        this.width = dto.width;
    }

    public String getKonvaname(){
        return Konvaname;
    }

    @Override
    public shape clone(String cloneid) throws CloneNotSupportedException {
        Text clonesquare = new Text(this);
        clonesquare.setId(cloneid);
        return clonesquare;
    }
}
