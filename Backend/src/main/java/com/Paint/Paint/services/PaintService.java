package com.Paint.Paint.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Service;

import com.Paint.Paint.services.shapes.shape;

@Service
public class PaintService {

    private static PaintService paintService =null;
    
    private PaintService() {
        // Private constructor to prevent instantiation from outside
    }
    
    public static PaintService getInstance(){
        if(paintService == null){
            paintService = new PaintService();
        }
        return paintService;
    }
    private Stack<List<shape>> allshapes=new Stack<>();
    private Stack<List<shape>> redo=new Stack<>();
    private HashMap<String,shape> shapesMap=new HashMap<>();
    private List<shape> getcurrentShapes(){
        if (!allshapes.empty()) {
            return new ArrayList<>(allshapes.peek());
        }
        return new ArrayList<>();
    }
    private void saveState(List<shape> shapes){
        allshapes.push(new ArrayList<>(shapes));
        redo.clear();
    }
    public void changedmap(){
        List<shape> currentShapes=getcurrentShapes();
        for(int i=0;i<currentShapes.size();i++){
            shape shape = currentShapes.get(i);
            shapesMap.put(shape.getId(), shape);
        }
    }
    public void addShape(shape shape){
        List<shape> currentShapes=getcurrentShapes();
        currentShapes.add(shape);
        shapesMap.put(shape.getId(), shape);
        saveState(currentShapes);
    }
    public List<shape> removShapes(String id){
        List<shape> currentShapes=getcurrentShapes();
        shape shapeToRemove=shapesMap.get(id);
        if(shapeToRemove!=null){
            currentShapes.remove(shapeToRemove);
            shapesMap.remove(id);
        }
        saveState(currentShapes);
        return currentShapes;
    }
    public  shape getShapeById(String shapeId) {
        return shapesMap.get(shapeId);
    }
    public void clearAllshapes() {
        saveState(new ArrayList<>());
    }
    public List<shape> redo(){
        if(!redo.isEmpty()){
            allshapes.push(redo.pop());
            changedmap();
            return getcurrentShapes();
    }
    changedmap();
    return getcurrentShapes();
    
    }
    public List<shape> undo(){
        if(!allshapes.isEmpty()){
            redo.push(allshapes.pop());
            changedmap();
            return getcurrentShapes();
        }
        return new ArrayList<shape>();
    }
    public void printShapeStack() {
        System.out.println("Printing all shapes ");
        for (List<shape> shapes : allshapes) {
            System.out.println("Element no:");
            for (shape shape : shapes) {
                System.out.println(shape.toString());
            }
        }
    }
    public void savejson(String path, String id)throws IOException {
        Savefiles savefiles = new Savefiles();
        savefiles.setId(id);
        savefiles.setShapetosaved(getcurrentShapes());
        savefiles.json(path);
    }
    public Savefiles loadfromjson(String path) throws IOException {
        Savefiles loadfiles = new Savefiles();
        if (loadfiles!=null) {
            List<shape> currShapes =getcurrentShapes();
            currShapes.addAll(loadfiles.getShapetosaved());
            saveState(currShapes);
            changedmap();
            return loadfiles;
        }
        else{
            return null;
        }
    }
    public Savefiles loadjson(String path) throws IOException {
        return loadfromjson(path);
    }

}