package com.vikas.EcomProductService.Service;

import com.vikas.EcomProductService.DTO.ProductListResponseDTO;
import com.vikas.EcomProductService.DTO.ProductResponseDTO;
import com.vikas.EcomProductService.Model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductById(int id);
    Product createProduct(Product product);
    Product deleteProduct(int id);
    Product updateProduct(int id, Product updatedProduct);
}
