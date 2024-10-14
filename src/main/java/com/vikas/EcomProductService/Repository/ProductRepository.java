package com.vikas.EcomProductService.Repository;

import com.vikas.EcomProductService.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findProductByTitle(String title);
    Product findProductByTitleAndDescription(String title, String description); // select * from Product where title = ? and description = ?
    Product findProductByTitleOrDescription(String title, String description); // select * from Product where title = ? or description = ?
    Product findProductByPriceLessThan(double price); // < price
    Product findProductByPriceLessThanEqual(double price); // <= price
    Product findProductByPriceGreaterThan(double price); // > price
    Product findProductByPriceGreaterThanEqual(double price); // >= price
    Product findProductByPriceBetweenStartPriceAndEndPrice(double startPrice, double endPrice); // <= x <=
}
