package com.vikas.EcomProductService.Service;

import com.vikas.EcomProductService.DTO.ProductListResponseDTO;
import com.vikas.EcomProductService.DTO.ProductResponseDTO;
import com.vikas.EcomProductService.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        String getAllProductsURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductListResponseDTO> listResponseEntity =
                restTemplate.getForEntity(getAllProductsURL, ProductListResponseDTO.class);
        // need to done again
        return listResponseEntity.getBody();
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        String getAllProductsURL = "https://fakestoreapi.com/products/" + id ;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> listResponseEntity =
                restTemplate.getForEntity(getAllProductsURL, ProductResponseDTO.class);
        return listResponseEntity.getBody();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(int id) {
        return null;
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }
}
