package com.ecom.ProductService.controllers;

import com.ecom.ProductService.models.Product;
import com.ecom.ProductService.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId) {
        return new ResponseEntity<>(productService.getSingleProduct(productId), HttpStatus.OK);
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
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
