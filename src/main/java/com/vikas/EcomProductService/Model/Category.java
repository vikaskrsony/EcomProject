package com.vikas.EcomProductService.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String categoryName;

//    @OneToMany(mappedBy = "category")
//    //@JoinColumn(name = "category_id")
//    private List<Product> products;

}
