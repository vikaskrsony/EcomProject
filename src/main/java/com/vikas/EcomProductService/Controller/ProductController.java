package com.vikas.EcomProductService.Controller;

import com.vikas.EcomProductService.DTO.ProductListResponseDTO;
import com.vikas.EcomProductService.DTO.ProductRequestDTO;
import com.vikas.EcomProductService.DTO.ProductResponseDTO;
import com.vikas.EcomProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class ProductController {

   /**
     Field Injection
     @Autowired
    @Qualifier("fakeStoreProductService")
    ProductService productService;
   **/


    private final ProductService productService;

    @Autowired
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

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
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") int id) {
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

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Boolean> deleteProductById(@PathVariable int id){
        boolean response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
    }

}
