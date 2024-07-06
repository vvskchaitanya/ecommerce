package com.vvsk.ecommerce.ecommerceapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;
    
    @ManyToOne
    @JoinColumn(name = "product", nullable = false)
    private ProductEntity product;
    
    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;
    
    @Column(nullable = false)
    private int quantity;
    
    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;
    
    @Column(nullable = false, length = 50)
    private String status;
    
    @Column(name = "shipping_address", nullable = false, length = 255)
    private String shippingAddress;
    
    @Column(name = "billing_address", nullable = false, length = 255)
    private String billingAddress;
    
    @Column(name = "payment_method", nullable = false, length = 50)
    private String paymentMethod;

    
}
