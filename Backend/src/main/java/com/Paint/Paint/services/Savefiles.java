package com.Paint.Paint.services;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.Paint.Paint.services.shapes.shape;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Savefiles {

    List <shape> shapetosaved =new ArrayList<>();
    
    public List<shape> getShapetosaved() {
        return shapetosaved;
    }
    public void setShapetosaved(List<shape> shapetosaved) {
        this.shapetosaved = shapetosaved;
    }
    public void saveToXML(String path) throws IOException {
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)))) {
            encoder.writeObject(this);
        }
    }
    public static Savefiles loadFromXML(String path) throws IOException {
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)))) {
            return (Savefiles) decoder.readObject();
        }
    }
    public void json(String path) throws IOException{
        //save to json file
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(path), this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Savefiles fromJson(String path) throws IOException{
        //load from json file
        try {
        ObjectMapper mapper = new ObjectMapper();
        Savefiles object = mapper.readValue(new File(path), Savefiles.class);
        return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null ;
        }  
    } 
}
