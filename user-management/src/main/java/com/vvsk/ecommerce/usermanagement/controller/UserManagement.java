package com.vvsk.ecommerce.usermanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagement {

    @RequestMapping("/users/register")
    public String register(){
        return "success";
    }

}
