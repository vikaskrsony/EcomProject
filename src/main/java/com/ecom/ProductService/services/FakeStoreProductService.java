package com.ecom.ProductService.services;

import com.ecom.ProductService.dtos.FakeStoreProductDto;
import com.ecom.ProductService.exceptions.ProductNotFoundException;
import com.ecom.ProductService.mapper.Mapper;
import com.ecom.ProductService.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    //Note : This service class will implement all the API's using FakeStore

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        throw  new ProductNotFoundException("Failed");
//        ResponseEntity<FakeStoreProductDto> fakeStoreProductDto = restTemplate.getForEntity("https://fakestoreapi.com/products/" + productId,
//                FakeStoreProductDto.class);
//        return Mapper.convertFakeStoreDtoToProduct(fakeStoreProductDto.getBody());
    }

    @Override
    public List<Product> getAllProduct() {
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtoResponse = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProductDtos = fakeStoreProductDtoResponse.getBody();
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(Mapper.convertFakeStoreDtoToProduct(fakeStoreProductDto));
        }
        return products;

    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }
}
