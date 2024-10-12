package com.vikas.EcomProductService.Repository;

import com.vikas.EcomProductService.Model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, UUID> {
}