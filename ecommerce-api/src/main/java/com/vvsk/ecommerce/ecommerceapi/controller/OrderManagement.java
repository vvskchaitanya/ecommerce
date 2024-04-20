package com.vvsk.ecommerce.ecommerceapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/orders")
public class OrderManagement {

    @Operation(summary = "To retrieve orders of user")
    @GetMapping("/")
    public String list(){
        return "success";
    }

    @Operation(summary = "To fetch order information of provided order")
    @GetMapping("/{id}")
    public String get(){
        return "success";
    }

    @Operation(summary = "Request to place new order")
    @PostMapping("/new")
    public String add(){
        return "success";
    }

}
