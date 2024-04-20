package com.vvsk.ecommerce.ecommerceapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductManagement {

    @GetMapping("/")
    public String list(){
        return "success";
    }

    @GetMapping("/{id}")
    public String get(){
        return "success";
    }

    @PostMapping("/add")
    public String add(){
        return "success";
    }

    @DeleteMapping("/{id}")
    public String delete(){
        return "success";
    }

}
