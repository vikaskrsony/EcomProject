package com.vikas.EcomProductService.Service;

import com.vikas.EcomProductService.DTO.ProductListResponseDTO;
import com.vikas.EcomProductService.DTO.ProductRequestDTO;
import com.vikas.EcomProductService.DTO.ProductResponseDTO;
import com.vikas.EcomProductService.Exception.InvalidTitleException;
import com.vikas.EcomProductService.Exception.ProductNotFoundException;
import com.vikas.EcomProductService.Mapper.ProductMapper;
import com.vikas.EcomProductService.Model.Product;
import com.vikas.EcomProductService.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {

        List<Product> products = productRepository.findAll();
        return ProductMapper.convertProductsToProductListResponseDTO(products);
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        return null;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        return null;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }

    @Override
    public ProductResponseDTO findProductByTitle(String title) throws RuntimeException {
        if(title == null || title.isEmpty()){
            throw new InvalidTitleException("title is invalid");
        }
        Product product = productRepository.findProductByTitle(title);
        if(product == null){
            throw new ProductNotFoundException("Product with given title is not available");
        }
        ProductResponseDTO productResponseDTO = ProductMapper.productToProductResponseDTO(product);
        return productResponseDTO;
    }

}
