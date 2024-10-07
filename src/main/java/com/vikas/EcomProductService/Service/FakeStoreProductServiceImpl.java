package com.vikas.EcomProductService.Service;

import com.vikas.EcomProductService.Client.FakeStoreAPIClient;
import com.vikas.EcomProductService.DTO.*;
import com.vikas.EcomProductService.Exception.ProductNotFoundException;
import com.vikas.EcomProductService.Mapper.ProductMapper;
import com.vikas.EcomProductService.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.vikas.EcomProductService.Mapper.ProductMapper.*;
import static com.vikas.EcomProductService.Util.ProductUtils.*;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        /** Service layer impl to call 3rd Party
         String getAllProductsURL = "https://fakestoreapi.com/products";
         RestTemplate restTemplate = restTemplateBuilder.build();
         ResponseEntity<ProductResponseDTO[]> arrayResponseEntity =
         restTemplate.getForEntity(getAllProductsURL, ProductResponseDTO[].class);

         ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
         for (ProductResponseDTO productResponseDTO : arrayResponseEntity.getBody()) {
         productListResponseDTO.getProducts().add(productResponseDTO);
         }
         return productListResponseDTO; **/
        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOList = fakeStoreAPIClient.getAllProducts();
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for (FakeStoreProductResponseDTO fakeStoreProductResponseDTO : fakeStoreProductResponseDTOList) {
            productListResponseDTO.getProducts().add(fakeStoreProductResponseDTOProductResponseDTO(fakeStoreProductResponseDTO));
        }
        return productListResponseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(int id) throws ProductNotFoundException {
        /** Service layer impl to call 3rd Party
         String getAllProductsURL = "https://fakestoreapi.com/products/" + id;
         RestTemplate restTemplate = restTemplateBuilder.build();
         ResponseEntity<ProductResponseDTO> listResponseEntity =
         restTemplate.getForEntity(getAllProductsURL, ProductResponseDTO.class);
         return listResponseEntity.getBody();
         **/
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.getProductById(id);
        if (isNull(fakeStoreProductResponseDTO)) {
            throw new ProductNotFoundException("Product not found with id : " + id);
        }
        return fakeStoreProductResponseDTOProductResponseDTO(fakeStoreAPIClient.getProductById(id));

    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        /** Service layer impl to call 3rd Party
         String createProductURl = "https://fakestoreapi.com/products/";
         RestTemplate restTemplate = restTemplateBuilder.build();
         ResponseEntity<ProductResponseDTO> responseDTOResponseEntity =
         restTemplate.postForEntity(createProductURl, productRequestDTO, ProductResponseDTO.class);
         return responseDTOResponseEntity.getBody(); **/


        /** Used Mapper class for this conversion
         ProductResponseDTO productResponseDTO = new ProductResponseDTO();
         productResponseDTO.setId(21);
         productResponseDTO.setTitle(fakeStoreProductResponseDTO.getTitle());
         productResponseDTO.setCategory(fakeStoreProductResponseDTO.getCategory());
         productResponseDTO.setPrice(fakeStoreProductResponseDTO.getPrice());
         productResponseDTO.setImage(fakeStoreProductResponseDTO.getImage());
         productResponseDTO.setDescription(fakeStoreProductResponseDTO.getDescription());
         return productResponseDTO;
         **/
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = ProductMapper.productRequestToFakeStoreProductRequest(productRequestDTO);

        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);

        /** Static import of static method
         With the help of static import we can directly use the static method of any class and with this our code will look more cleaner
         ProductResponseDTO productResponseDTO = ProductMapper.fakeStoreProductResponseDTOProductResponseDTO(fakeStoreProductResponseDTO);
         instead of upper line we can use directly :  fakeStoreProductResponseDTOProductResponseDTO(fakeStoreProductResponseDTO);
         **/
        return fakeStoreProductResponseDTOProductResponseDTO(fakeStoreProductResponseDTO);
    }

    @Override
    public boolean deleteProduct(int id) {
        /** Service layer impl to call 3rd Party
         String deleteProductURl = "https://fakestoreapi.com/products/" + id;
         RestTemplate restTemplate = restTemplateBuilder.build();
         restTemplate.delete(deleteProductURl);
         return true;
         **/
        fakeStoreAPIClient.deleteProduct(id);
        return true;
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }
}
