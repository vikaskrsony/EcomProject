package com.vikas.EcomProductService.Controller;

import com.vikas.EcomProductService.DTO.ProductListResponseDTO;
import com.vikas.EcomProductService.DTO.ProductResponseDTO;
import com.vikas.EcomProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController

public class ProductController {

    @Autowired
    @Qualifier("fakeStoreProductService")
    ProductService productService;



    @GetMapping("/product")
    public ResponseEntity<ProductListResponseDTO> getAllProducts() {
       /* ProductResponseDTO p1 = new ProductResponseDTO();
        p1.setId(1);
        p1.setTitle("Iphone 15 pro");
        p1.setPrice(1500000);
        p1.setImage("www.google.com/image/iphone");
        p1.setDescription("Very costly phone");
        p1.setCategory("Electronics");

        ProductResponseDTO p2 = new ProductResponseDTO();
        p2.setId(2);
        p2.setTitle("Macbook pro");
        p2.setPrice(2500000);
        p2.setImage("www.google.com/image/macbook");
        p2.setDescription("Very costly laptop");
        p2.setCategory("Electronics");

        List<ProductResponseDTO> responseDTOList = Arrays.asList(p1, p2);
        return ResponseEntity.ok(responseDTOList);
        */
        ProductListResponseDTO products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable int id) {
       /* ProductResponseDTO p1 = new ProductResponseDTO();
        p1.setId(1);
        p1.setTitle("Iphone 15 pro");
        p1.setPrice(1500000);
        p1.setImage("www.google.com/image/iphone");
        p1.setDescription("Very costly phone");
        p1.setCategory("Electronics");

        ProductResponseDTO p2 = new ProductResponseDTO();
        p2.setId(2);
        p2.setTitle("Macbook pro");
        p2.setPrice(2500000);
        p2.setImage("www.google.com/image/macbook");
        p2.setDescription("Very costly laptop");
        p2.setCategory("Electronics");

        List<ProductResponseDTO> responseDTOList = Arrays.asList(p1, p2);
        return ResponseEntity.ok(responseDTOList);
        */
        ProductResponseDTO products = productService.getProductById(id);
        return ResponseEntity.ok(products);
    }

}
