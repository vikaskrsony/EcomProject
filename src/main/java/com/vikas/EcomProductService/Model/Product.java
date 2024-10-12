package com.vikas.EcomProductService.Model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;

    @ManyToOne
    private Category category;

    @OneToOne
    private Price price;

}
/*
    Product - Category
     1          1
     M          1
     =============
     M : 1
 */
