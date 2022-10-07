package com.example.orderservice.entity;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Table(name = "orders")
public class OrderEntity extends BaseTimeEntity implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 120, unique = true)
    private String productId;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Integer unitPrice;
    @Column(nullable = false)
    private Integer totalPrice;

    @Column(nullable = false)
    private String userId;
    @Column(nullable = false, unique = true)
    private String orderId;

}
