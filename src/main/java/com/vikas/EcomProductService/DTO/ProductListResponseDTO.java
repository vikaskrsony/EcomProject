package com.vikas.EcomProductService.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductListResponseDTO {
  List<ProductResponseDTO> products;
}
