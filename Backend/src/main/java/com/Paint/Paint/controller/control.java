package com.Paint.Paint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Paint.Paint.services.PaintService;
import com.Paint.Paint.services.Savefiles;
import com.Paint.Paint.services.shapes.ShapeFactory;
import com.Paint.Paint.services.shapes.Shapecreate;
import com.Paint.Paint.services.shapes.shape;



@RestController()
@CrossOrigin("*")
@RequestMapping("/paint")
public class control {

    @Autowired 
    public  PaintService paintService;

    @PostMapping("/create")
    public ResponseEntity<Object>createshape(@RequestBody Shapecreate docreate){
        try {
            ShapeFactory shapeFactory = new ShapeFactory();
            shape object =shapeFactory.createShape(docreate);
            paintService.addShape(object);
            return ResponseEntity.ok("Shape Created Successfully"); //obj
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
         }
        }
        @PutMapping("update")
        public ResponseEntity<Object> updateshape(@RequestBody Shapecreate docreate){
            try {
                ShapeFactory shapeFactory = new ShapeFactory();
                shape newobject =shapeFactory.createShape(docreate);
                paintService.updateshape(newobject);
                return ResponseEntity.ok("Shape Updated Successfully");
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
            }
        }
        @PostMapping("clone/{id}/{cloneid}")
        public ResponseEntity<shape> clone(@PathVariable String id, @PathVariable String cloneid){
             try{
                shape s =paintService.getShapeById(id).clone(cloneid);
                paintService.addShape(s);
                return ResponseEntity.ok(s);
             }
             catch(Exception e){
                 e.printStackTrace();
                 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
             }
        }
        @PostMapping("undo")
        public ResponseEntity<List<shape>> undo(){
             try{
                List<shape> s = paintService.undo();
                return ResponseEntity.ok(s);
             }
             catch(Exception e){
                 e.printStackTrace();
                 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
             }
        }
        @PostMapping("/save")
        public ResponseEntity<String> save(@RequestParam String path,@RequestParam String idCounter){
             try{
                return ResponseEntity.ok(paintService.savejson(path, idCounter));
             }
             catch(Exception e){
                 e.printStackTrace();
                 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
             }
        }
        @PostMapping("/load")
        public ResponseEntity<Savefiles> load(@RequestParam String path){
             try{
                return ResponseEntity.ok(paintService.loadjson(path));
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
