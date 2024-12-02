package com.Paint.Paint.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Service;

import com.Paint.Paint.services.shapes.ShapeDTO;
import com.Paint.Paint.services.shapes.shape;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    private Stack<List<shape>> undo=new Stack<>();
    private Stack<List<shape>> redo=new Stack<>();
    
    public shape getShapeById(String id){
        List<shape> currentShapes = new ArrayList<>(undo.peek());
        shape shape = currentShapes.get(0);
        for(int i=0;i<currentShapes.size();i++){
            shape = currentShapes.get(i);
            if(shape.getId().equals(id)){
                break;
            }
        }
        return shape;
    }
    
    public void clearAll() {
        undo.push(new ArrayList<>());
    }

    public void addShape(shape shape){
        redo.clear();
        List<shape> currentShapes = new ArrayList<>();
        if(!undo.isEmpty()){
            currentShapes = new ArrayList<>(undo.peek());
        }
        currentShapes.add(shape);
        undo.push(currentShapes);
        printStack();
    }

    public List<shape> removeShapes(String id){
        redo.clear();
        if(undo.isEmpty()){return null;}
        List<shape> currentShapes = new ArrayList<>(undo.peek());
        shape shape = getShapeById(id);
        currentShapes.remove(shape);
        undo.push(currentShapes);
        return currentShapes;
    }

    public List<shape> redo() {
        if (redo.isEmpty()) {
            System.out.println("Redo stack is empty");
            return undo.peek();
        }
        undo.push(redo.pop());
        return undo.peek();
    }

    public List<shape> undo() {
        if (undo.isEmpty()) {
            System.out.println("Undo empty");
            return null;
        }
        redo.push(undo.pop());
        if(undo.isEmpty()){return null;}
        return undo.peek();
    }

    public void printStack() {
        System.out.println("Printing all shapes in undo stack ");
        for (List<shape> shapes : undo) {
            System.out.println("Element no:");
            for (shape shape : shapes) {
                System.out.println(shape.toString());
            }
        }
        System.out.println("---------------------------------------------------------");
    }

    public void updateshape(ShapeDTO update) throws CloneNotSupportedException {
        redo.clear();
        List<shape> currentShapes = new ArrayList<>();
        for (shape originalShape : undo.peek()) {
            if(originalShape.getId().equals(update.id)){
                shape copiedShape = originalShape.clone(originalShape.getId());
                currentShapes.add(copiedShape);
            }
            else{
                currentShapes.add(originalShape);
            }
        }
        shape shape = currentShapes.get(0);
        for(int i=0;i<currentShapes.size();i++){
            shape = currentShapes.get(i);
            if(shape.getId().equals(update.id)){
                break;
            }
        }
        shape.update(update);
        undo.push(currentShapes);
        printStack();
    }

    public ShapeDTO updateDTO(ShapeDTO dto, double newX, double newY){
        if(dto.name.equals("Line")){
            dto.points.add(0.0);
            dto.points.add(0.0);
            dto.points.add(newX - dto.x);
            dto.points.add(newY - dto.y);
        }
        else if(dto.name.equals("ellipse")){
            dto.radiusY = Math.abs(newY - dto.y);
            dto.radiusX = Math.abs(newX - dto.x);
        }
        else if(dto.name.equals("Rect") || dto.name.equals("text")){
            dto.height = newY - dto.y;
            dto.width = newX - dto.x;
        }
        else if(dto.name.equals("square")) {
            dto.height = newY - dto.y;
            dto.width = dto.height;
        }
        else if(dto.name.equals("Circle") || dto.name.equals("triangle") || dto.name.equals("polygon") || dto.name.equals("hexagon") || dto.name.equals("pentagon")){
            dto.radius = Math.sqrt(Math.pow(newY - dto.y,2)+ Math.pow(newX - dto.x,2));
        }

        return dto;
    }
    public void savetoxml(String path) throws IOException {
        if (undo.isEmpty()) {
            throw new IllegalStateException("Undo stack is empty. Cannot save.");
        }
        Savefiles savefiles = new Savefiles();
        savefiles.setShapetosaved(undo.peek());
        savefiles.saveToXML(path);
        System.out.println("Saved to XML at: " + path);
    }

    public Savefiles loadfromxml(String path) throws IOException {
        Savefiles loadfiles = Savefiles.loadFromXML(path);
        if (loadfiles != null) {
            System.out.println("Loaded XML Content:");
            System.out.println(loadfiles.getShapetosaved());
            return loadfiles;
        } else {
            System.out.println("No content found in the XML file.");
            return null;
        }
    }

    public void savejson(String path) throws IOException {
        if (undo.isEmpty()) {
            throw new IllegalStateException("Undo stack is empty. Cannot save.");
        }
        Savefiles savefiles = new Savefiles();
        savefiles.setShapetosaved(undo.peek());
        savefiles.savejson(path);
        System.out.println("Saved to JSON at: " + path);
    }

    public Savefiles loadfromjson(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Savefiles loadfiles = objectMapper.readValue(new File(path), Savefiles.class);
        if (loadfiles != null) {
            System.out.println("Loaded JSON Content:");
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(loadfiles));
            return loadfiles;
        } else {
            System.out.println("No content found in the JSON file.");
            return null;
        }
    }
    public String savechoice(String path) throws IOException {
        if (path.endsWith(".json")) {
            savejson(path);
            return "Saved to " + path;
        } else if (path.endsWith(".xml")) {
            savetoxml(path);
            return "Saved to " + path;
        } else {
            throw new IllegalArgumentException("Unsupported file format. Please use '.json' or '.xml'.");
            }
        }
    public Savefiles loadchoice(String path) throws IOException {
        System.out.println(path.endsWith(".json"));
        System.out.println(path.endsWith(".xml"));
        if (path.endsWith(".json")) {
            return loadfromjson(path);
        } else if (path.endsWith(".xml")) {
            return loadfromxml(path);
        } else {
            throw new IllegalArgumentException("Unsupported file format. Please use '.json' or '.xml'.");
        }
    }
}
