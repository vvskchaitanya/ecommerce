package com.vvsk.ecommerce.ecommerceapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserManagement {

    @GetMapping("/")
    public String list(){
        return "success";
    }

    @GetMapping("/{username}")
    public String get(){
        return "success";
    }

    @PostMapping("/register")
    public String register(){
        return "success";
    }

    @DeleteMapping("/{username}")
    public String delete(){
        return "success";
    }

}
