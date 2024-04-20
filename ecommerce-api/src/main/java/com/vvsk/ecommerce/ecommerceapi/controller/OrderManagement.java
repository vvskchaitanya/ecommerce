package com.vvsk.ecommerce.ecommerceapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderManagement {

    @GetMapping("/")
    public String list(){
        return "success";
    }

    @GetMapping("/{id}")
    public String get(){
        return "success";
    }

    @PostMapping("/")
    public String add(){
        return "success";
    }

}
