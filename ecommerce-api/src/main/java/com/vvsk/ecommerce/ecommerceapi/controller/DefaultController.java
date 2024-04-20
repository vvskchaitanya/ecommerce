package com.vvsk.ecommerce.ecommerceapi.controller;

@RequestMapping("/")
@Controller
public class DefaultController {

    @GetMapping("")
    public String redirectToSwagger() {
        return "redirect:/swagger-ui/index.html";
    }



}
