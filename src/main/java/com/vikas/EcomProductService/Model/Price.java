package com.vikas.EcomProductService.Model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Price extends BaseModel{
    private String currency;
    private double amount;
    private double discount;
}