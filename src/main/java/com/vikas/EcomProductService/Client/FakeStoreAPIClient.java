package com.vikas.EcomProductService.Client;

import com.vikas.EcomProductService.DTO.FakeStoreProductRequestDTO;
import com.vikas.EcomProductService.DTO.FakeStoreProductResponseDTO;
import com.vikas.EcomProductService.DTO.ProductRequestDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreAPIClient {
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO) {
        String createProductURl = "https://fakestoreapi.com/products/";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> responseDTOResponseEntity =
                restTemplate.postForEntity(createProductURl, fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return responseDTOResponseEntity.getBody();
    }
}