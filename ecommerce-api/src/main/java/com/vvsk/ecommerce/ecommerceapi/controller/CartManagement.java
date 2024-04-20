package com.vvsk.ecommerce.ecommerceapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/cart")
public class CartManagement {

    @Operation(summary = "Fetch items in cart")
    @GetMapping("/")
    public String get(){
        return "success";
    }

    @Operation(summary = "Add item to cart")
    @PostMapping("/{id}")
    public String add(){
        return "success";
    }

    @Operation(summary = "Remove item from cart")
    @DeleteMapping("/{id}")
    public String remove(){
        return "success";
    }

}
