package com.vvsk.ecommerce.ecommerceapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartManagement {

    @GetMapping("/{username}")
    public String get(){
        return "success";
    }

    @PostMapping("/{username}")
    public String update(){
        return "success";
    }

}
