package com.ecom.ProductService.dtos;

import com.ecom.ProductService.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundExceptionDTO {
    private int productId;
    private String message;

}
