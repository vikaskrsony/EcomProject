package com.ecom.ProductService.controllers;

import com.ecom.ProductService.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId) {
        return new Product();
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody Product product) {
        return new Product();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delteProduct(@PathVariable("id") Long productId) {
        return (ResponseEntity<Void>) ResponseEntity.ok();
    }
}
