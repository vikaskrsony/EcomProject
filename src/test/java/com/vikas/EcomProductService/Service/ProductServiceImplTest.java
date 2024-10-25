package com.vikas.EcomProductService.Service;


import com.vikas.EcomProductService.DTO.ProductResponseDTO;
import com.vikas.EcomProductService.Exception.InvalidTitleException;
import com.vikas.EcomProductService.Exception.ProductNotFoundException;
import com.vikas.EcomProductService.Model.Category;
import com.vikas.EcomProductService.Model.Price;
import com.vikas.EcomProductService.Model.Product;
import com.vikas.EcomProductService.Repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Scanner;
import java.util.UUID;

public class ProductServiceImplTest {
    @Mock //--> we need the mock object of the given attribute, here we are mocking the object of ProductRepository
    private ProductRepository productRepository;

    @InjectMocks //--> this is the class we will test, and this where we will use mock object
    private ProductServiceImpl productService;

    @BeforeEach
    public void setup() {
        System.out.println("BeforeEach method"); //--> this will get executed for each method with brand-new objects
        MockitoAnnotations.openMocks(this); //--> this will create a new object everytime and close/destroy after testing that object
    }

    @Test
    public void testFindProductByTitleSuccess() throws InvalidTitleException {
        //Arrange
        Price mockPrice = new Price();
        mockPrice.setAmount(100);

        Category mockCategory = new Category();
        mockCategory.setCategoryName("mockCategory");

        String testTitle = "vikas";

        Product mockProduct = new Product();
        mockProduct.setId(UUID.randomUUID());
        mockProduct.setTitle(testTitle);
        mockProduct.setDescription("testDescription");
        mockProduct.setPrice(mockPrice);
        mockProduct.setCategory(mockCategory);

        when(productRepository.findProductByTitle(testTitle)).thenReturn(mockProduct);
        //Act
        ProductResponseDTO actualResponse = productService.findProductByTitle(testTitle);
        //Asset
        Assertions.assertEquals(actualResponse.getTitle(), mockProduct.getTitle());
        Assertions.assertEquals(actualResponse.getDescription(), mockProduct.getDescription());
        Assertions.assertEquals(actualResponse.getId(), mockProduct.getId());

    }

    @Test
    public void testFindByProductByTitle_RepoRespondsWithNullObject() throws ProductNotFoundException {
        String testTitle = "testProductTitle";
        when(productRepository.findProductByTitle(testTitle)).thenReturn(null);
        Assertions.assertThrows(ProductNotFoundException.class, () -> productService.findProductByTitle(testTitle));
    }

    @Test
    public void testFindProductByTitle_NullTitle() throws InvalidTitleException {
        //Arrange
        Price mockPrice = new Price();
        mockPrice.setAmount(100);

        Category mockCategory = new Category();
        mockCategory.setCategoryName("mockCategory");

        String testTitle = null;

        Product mockProduct = new Product();
        mockProduct.setId(UUID.randomUUID());
        mockProduct.setTitle(testTitle);
        mockProduct.setDescription("testDescription");
        mockProduct.setPrice(mockPrice);
        mockProduct.setCategory(mockCategory);

        when(productRepository.findProductByTitle(testTitle)).thenReturn(mockProduct);
        //Act & Assert
        Assertions.assertThrows(InvalidTitleException.class, ()-> productService.findProductByTitle(testTitle));

    }

    @Test
    public void testFindProductByTitle_EmptyTitle() throws InvalidTitleException {
        //Arrange
        Price mockPrice = new Price();
        mockPrice.setAmount(100);

        Category mockCategory = new Category();
        mockCategory.setCategoryName("mockCategory");

        String testTitle = "";

        Product mockProduct = new Product();
        mockProduct.setId(UUID.randomUUID());
        mockProduct.setTitle(testTitle);
        mockProduct.setDescription("testDescription");
        mockProduct.setPrice(mockPrice);
        mockProduct.setCategory(mockCategory);

        when(productRepository.findProductByTitle(testTitle)).thenReturn(mockProduct);
        //Act & Assert
        Assertions.assertThrows(InvalidTitleException.class, ()-> productService.findProductByTitle(testTitle));

    }
}
