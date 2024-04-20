package com.vvsk.ecommerce.ecommerceapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/products")
public class ProductManagement {

    @Operation(summary="Retrieve all products")
    @GetMapping("/")
    public String list(){
        return "success";
    }

    @Operation(summary="Retrieve information of product")
    @GetMapping("/{id}")
    public String get(){
        return "success";
    }

    @Operation(summary="Add new product to application")
    @PostMapping("/add")
    public String add(){
        return "success";
    }

    @Operation(summary="Remove product from application")
    @DeleteMapping("/{id}")
    public String delete(){
        return "success";
    }

}
