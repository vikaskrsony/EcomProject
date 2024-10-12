package com.vikas.EcomProductService.Repository;

import com.vikas.EcomProductService.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}