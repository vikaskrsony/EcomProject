package com.vikas.EcomProductService.Client;

import com.vikas.EcomProductService.DTO.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreAPIClient {
    private RestTemplateBuilder restTemplateBuilder;

    private String fakeStoreAPIURL;

    @Value("{fakeStore.api.path.product}")
    private String fakeStoreAPIPathProduct; // here is field injection but constructor is best and recommended

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder,
                              @Value("{fakeStore.api.url}") String fakeStoreAPIURL) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIURL = fakeStoreAPIURL;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO) {
        //String createProductURl = "https://fakestoreapi.com/products/";
        String createProductURl = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> responseDTOResponseEntity =
                restTemplate.postForEntity(createProductURl, fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return responseDTOResponseEntity.getBody();
    }

    public FakeStoreProductResponseDTO getProductById(int id) {
        //String getProductByURLId = "https://fakestoreapi.com/products/" + id;
        String getProductByURLId = fakeStoreAPIURL + fakeStoreAPIPathProduct + "/" + id;
                RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> listResponseEntity =
                restTemplate.getForEntity(getProductByURLId, FakeStoreProductResponseDTO.class);
        return listResponseEntity.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts() {
       // String getAllProductsURL = "https://fakestoreapi.com/products";
        String getAllProductsURL = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> arrayResponseEntity =
                restTemplate.getForEntity(getAllProductsURL, FakeStoreProductResponseDTO[].class);
        return List.of(arrayResponseEntity.getBody());
    }

    public void deleteProduct(int id){
       // String deleteProductURl = "https://fakestoreapi.com/products/" + id;
        String deleteProductURl = fakeStoreAPIURL + fakeStoreAPIPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductURl);
    }
}