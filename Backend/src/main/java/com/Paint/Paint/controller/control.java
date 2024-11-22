package com.Paint.Paint.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin("*")
//@RequestMapping("/paint")
public class control {

    //@PostMapping("/crete")
    @RequestMapping("/hi")
    public String hello() {
        return "hello";
    }
    

    
}
