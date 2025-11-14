package com.ecom.ProductService.services;

import com.ecom.ProductService.dtos.FakeStoreProductDto;
import com.ecom.ProductService.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);

    List<Product> getAllProduct();

    Product createProduct(Product product);

    boolean deleteProduct(Long productId);
}
