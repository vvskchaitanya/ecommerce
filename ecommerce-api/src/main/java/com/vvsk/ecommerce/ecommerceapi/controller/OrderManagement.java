package com.vvsk.ecommerce.ecommerceapi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/orders")
public class OrderManagement {

    @Operation(summary = "To retrieve orders of user")
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/")
    public String list(){
        return "success";
    }

    @Operation(summary = "To fetch order information of provided order")
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public String get(){
        return "success";
    }

    @Operation(summary = "Request to place new order")
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/new")
    public String add(){
        return "success";
    }

}
