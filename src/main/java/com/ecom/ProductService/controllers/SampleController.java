package com.ecom.ProductService.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {
    @Autowired
    HttpServletRequest httpServletRequest;

    @GetMapping("/hello")
    public String sample() {
        System.out.println("the requested path : " + httpServletRequest.getRequestURL());
        return "hello";
    }


    @GetMapping("/hi")
    public String hi(@RequestParam("name") String name , @RequestParam("id") int id){
        System.out.println("path is : " + httpServletRequest.getRequestURL());
        return "Hello : " + name + " : your id is : " + id;
    }
}
