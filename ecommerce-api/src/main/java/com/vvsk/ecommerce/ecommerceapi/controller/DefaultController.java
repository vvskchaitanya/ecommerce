package com.vvsk.ecommerce.ecommerceapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class DefaultController {

    @GetMapping("")
    public String redirectToSwagger() {
        return "redirect:/swagger-ui/index.html";
    }



}
