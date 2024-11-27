package com.Paint.Paint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Paint.Paint.services.PaintService;
import com.Paint.Paint.services.Savefiles;
import com.Paint.Paint.services.shapes.ShapeDTO;
import com.Paint.Paint.services.shapes.ShapeFactory;
import com.Paint.Paint.services.shapes.shape;



@RestController() //ll
@CrossOrigin("*")
@RequestMapping("/paint")
public class control {

    @Autowired 
    public  PaintService paintService;

    @PostMapping("/create")
    public ResponseEntity<Object> createShape(@RequestBody ShapeDTO dto) {
        try {
            System.out.println("arrivee");
            ShapeFactory factory = new ShapeFactory();
            shape obj = factory.createShape(dto);
            paintService.addShape(obj);
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
      }

      @PutMapping("/update")
      public ResponseEntity<Object> updateShape(@RequestBody ShapeDTO dto) {
          try {
              ShapeFactory factory = new ShapeFactory();
              shape updatedShape = factory.createShape(dto);
              paintService.updateshape(updatedShape);
              return ResponseEntity.ok(updatedShape);
          } catch (Exception e) {
              e.printStackTrace();
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
          }
      }
  
        @PostMapping("clone/{id}/{cloneid}")
        public ResponseEntity<shape> clone(@PathVariable String idOld , @PathVariable String idNew ){
            System.out.println("arriave");
            try {
                shape s = paintService.getShapeById(idOld).clone(idNew);
                paintService.addShape(s);
                return ResponseEntity.ok(s);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }
      @DeleteMapping("/remove/{shapeId}")
      public ResponseEntity<List<shape>> removeShape(@PathVariable String shapeId) {
        try {
           return ResponseEntity.ok(paintService.removShapes(shapeId));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping("/undo")
    public ResponseEntity<List<shape>> undo() {
        try {
            List<shape> result = paintService.undo();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping("/redo")
    public ResponseEntity<List<shape>> redo() {
        try {
            List<shape> result = paintService.redo();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestParam String path) {
        System.out.println("sent");
        try {
            System.out.println("lllll");
            return ResponseEntity.ok(paintService.saveFactory(path));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save shapes ");
        }
    }
    
        @PostMapping("/load")
        public ResponseEntity<Savefiles> load(@RequestParam String path){
             try{
                return ResponseEntity.ok(paintService.loadFromjson(path));
             }
             catch(Exception e){
                 e.printStackTrace();
                 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
             }
        }
        
    //@PostMapping("/crete")
    @RequestMapping("/hi")
    public String hello() {
        return "hello";
    }
    
}
