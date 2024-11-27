package com.Paint.Paint.services;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.Paint.Paint.services.shapes.shape;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Savefiles {

     List<shape> lastUpdate = new ArrayList<>();


    public void setLastUpdate(List<shape> lastUpdate){
        this.lastUpdate = lastUpdate;
    }


    public List<shape> getLastUpdate(){
        return this.lastUpdate;
    }


    public void saveToJson(String path) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(path), this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public  static Savefiles loadToJson(String path) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Savefiles object = mapper.readValue(new File(path), Savefiles.class);
            return object;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}

