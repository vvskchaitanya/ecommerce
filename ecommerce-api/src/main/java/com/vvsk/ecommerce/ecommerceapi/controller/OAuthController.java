package com.vvsk.ecommerce.ecommerceapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
public class OAuthController {

    @PostMapping("/login")
    public String login(){
        return "success";
    }

}
