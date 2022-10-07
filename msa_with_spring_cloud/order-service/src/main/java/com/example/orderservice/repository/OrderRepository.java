package com.example.orderservice.repository;

import com.example.orderservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    Optional<OrderEntity> findOrderEntityByOrderId(String orderId);

    List<OrderEntity> findOrderEntitiesByUserId(String userId);
}
