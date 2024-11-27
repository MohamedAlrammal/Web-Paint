package com.Paint.Paint.services;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.Paint.Paint.services.shapes.shape;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Savefiles {

    String id =null;
    List <shape> shapetosaved =new ArrayList<>();
    
    public String getId() {
        return id;
    }
    
    public List<shape> getShapetosaved() {
        return shapetosaved;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setShapetosaved(List<shape> shapetosaved) {
        this.shapetosaved = shapetosaved;
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
