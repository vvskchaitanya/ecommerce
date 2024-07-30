package com.vvsk.ecommerce.ecommerceapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="cart")
public class CartEntity extends AuditableEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;
    
    @ManyToOne
    @JoinColumn(name = "product", nullable = false)
    private ProductEntity product;
    
    @Column(name = "quantity", nullable = false)
    private int quantity;
    
    @Column(name= "deleted", nullable = false)
    private boolean deleted = false;
}
