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

    @PutMapping("/mockCreate/{newX}/{newY}")
    public ResponseEntity<Object> mockCreate(@RequestBody ShapeDTO dto , @PathVariable double newX, @PathVariable double newY) {
        try {
            ShapeFactory factory = new ShapeFactory();
            dto = paintService.updateDTO(dto, newX, newY);
            shape updatedShape = factory.createShape(dto);
            return ResponseEntity.ok(updatedShape);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @PutMapping("/create/{newX}/{newY}")
    public ResponseEntity<Object> create(@RequestBody ShapeDTO dto, @PathVariable double newX, @PathVariable double newY) {
        try {
            if(dto.x == newX && dto.y == newY){
                return ResponseEntity.ok(dto);
            }
            ShapeFactory factory = new ShapeFactory();
            dto = paintService.updateDTO(dto, newX, newY);
            shape shape = factory.createShape(dto);
            paintService.addShape(shape);
            return ResponseEntity.ok(shape);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateShape(@RequestBody ShapeDTO dto) {
        try {
            paintService.updateshape(dto);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    @PostMapping("/clone/{idOld}/{idNew}")
    public ResponseEntity<shape> clone(@PathVariable String idOld , @PathVariable String idNew ){
        System.out.println("clone");
        try {
            System.out.println("cloned");
            shape s = paintService.getShapeById(idOld).clone(idNew);
            s.setX(s.getX()+ 20);
            s.setY(s.getY()+ 20);
            paintService.addShape(s);
            return ResponseEntity.ok(s);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @DeleteMapping("/clearAll")
    public void clearAll() {
        try {
            paintService.clearAll();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @DeleteMapping("/remove/{shapeId}")
    public ResponseEntity<List<shape>> removeShape(@PathVariable String shapeId) {
        try {
            return ResponseEntity.ok(paintService.removeShapes(shapeId));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping("/undo")
    public ResponseEntity<List<shape>> undo() {
        try {
            System.out.println("hello");
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
    public ResponseEntity<String> save(@RequestParam String path){
        try{
            System.out.println("hnnaaaaaaa");
            return ResponseEntity.ok(paintService.savechoice(path));
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
        }
    }
    @PostMapping("/load")
    public ResponseEntity<Savefiles> load(@RequestParam String path){
        try{
            return ResponseEntity.ok(paintService.loadchoice(path));
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}