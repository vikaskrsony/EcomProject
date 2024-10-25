package com.vikas.EcomProductService.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikas.EcomProductService.DTO.ProductListResponseDTO;
import com.vikas.EcomProductService.DTO.ProductRequestDTO;
import com.vikas.EcomProductService.DTO.ProductResponseDTO;
import com.vikas.EcomProductService.Exception.ProductNotFoundException;
import com.vikas.EcomProductService.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc; // --> helps us to make mock api calls

    @MockBean(name = "productService")
    private ProductService productService;

    //UT for controllers via APIs
    @Test
    public void getAllProductReturnEmptyListWhenNoProductAvailable() throws Exception {
        //arrange
        ProductListResponseDTO emptyProductListResponseDTO = new ProductListResponseDTO();
        when(productService.getAllProducts()).thenReturn(emptyProductListResponseDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/product"))
                .andExpect(status().is(200))
                .andExpect(content().string("{\"products\":[]}"));
    }

    @Test
    public void getAllProductReturnsProducts() throws Exception {
        //arrange
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        ProductResponseDTO product1 = new ProductResponseDTO();
        product1.setId(UUID.fromString("8f101c7f-161d-40b1-8b7e-d8234c9bf2f7"));
        product1.setTitle("Laptop");
        product1.setCategory("Electronics");
        product1.setDescription("Best Laptop");
        product1.setPrice(1000);
        product1.setImage("someImageURl");

        ProductResponseDTO product2 = new ProductResponseDTO();
        product2.setId(UUID.fromString("8f101c7f-161d-40b1-8b7e-d8234c9bf2f7"));
        product2.setTitle("SmartPhone");
        product2.setCategory("Electronics");
        product2.setDescription("Best Phone");
        product2.setPrice(500000);
        product2.setImage("someImageURl");


        productListResponseDTO.setProducts(List.of(product1, product2));

        when(productService.getAllProducts()).thenReturn(productListResponseDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/product"))
                .andExpect(status().is(200))
                .andExpect(content().string("{\"products\":[{\"id\":\"8f101c7f-161d-40b1-8b7e-d8234c9bf2f7\",\"title\":\"Laptop\",\"price\":1000.0,\"category\":\"Electronics\",\"description\":\"Best Laptop\",\"image\":\"someImageURl\"},{\"id\":\"8f101c7f-161d-40b1-8b7e-d8234c9bf2f7\",\"title\":\"SmartPhone\",\"price\":500000.0,\"category\":\"Electronics\",\"description\":\"Best Phone\",\"image\":\"someImageURl\"}]}"));
    }

    @Test
    public void createProductSuccess() throws Exception {
        //arrange
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setTitle("Laptop");
        productRequestDTO.setCategory("Electronics");
        productRequestDTO.setDescription("Best Laptop");
        productRequestDTO.setPrice(1000);
        productRequestDTO.setImage("someImageURl");

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(UUID.fromString("8f101c7f-161d-40b1-8b7e-d8234c9bf2f7"));
        productResponseDTO.setTitle("Laptop");
        productResponseDTO.setCategory("Electronics");
        productResponseDTO.setDescription("Best Laptop");
        productResponseDTO.setPrice(1000);
        productResponseDTO.setImage("someImageURl");

        String requestJson = convertToJson(productRequestDTO);
        String responseJson = convertToJson(productResponseDTO);

        when(productService.createProduct(eq(productRequestDTO))).thenReturn(productResponseDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/products").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().is(200))
                .andExpect(content().string(responseJson));
    }

    @Test
    public void deleteProductByIdSuccess() throws Exception {
        //arrange
        when(productService.deleteProduct(5)).thenReturn(true);
        mockMvc.perform(delete("/products/5"))
                .andExpect(status().is(200))
                .andExpect(content().string("true"));
    }

    @Test
    public void findProductByIdFailure() throws Exception {
        when(productService.getProductById(1)).thenThrow(new ProductNotFoundException());
        mockMvc.perform(MockMvcRequestBuilders.get("/product/1"))
                .andExpect(status().is(404))
                .andExpect(content().string("{\"message\":null,\"messageCode\":404}"));

    }

    private String convertToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }



}
