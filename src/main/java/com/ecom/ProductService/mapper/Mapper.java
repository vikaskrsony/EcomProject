package com.ecom.ProductService.mapper;

import com.ecom.ProductService.dtos.FakeStoreProductDto;
import com.ecom.ProductService.models.Category;
import com.ecom.ProductService.models.Product;

public class Mapper {
    public static Product convertFakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        if (fakeStoreProductDto == null) return null;
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImageUrl());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getTitle());
        product.setCategory(category);
        return product;
    }
}
