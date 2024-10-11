package com.vikas.EcomProductService.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private double price;
    private String description;
    private String image;

    @ManyToOne
    private Category category;
}
/*
    Product - Category
     1          1
     M          1
     =============
     M : 1
 */
