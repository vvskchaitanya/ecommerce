package com.vvsk.ecommerce.ecommerceapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vvsk.ecommerce.ecommerceapi.dto.common.Product;
import com.vvsk.ecommerce.ecommerceapi.mapper.ProductMapper;
import com.vvsk.ecommerce.ecommerceapi.repository.ProductRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/products")
public class ProductManagement {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper mapper;

    @Operation(summary="Retrieve all products")
    @GetMapping("/")
    public ResponseEntity<List<Product>> list(){
        List<Product> products = productRepository.findAll().stream().map(mapper::map).collect(Collectors.toList());    
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @Operation(summary="Retrieve information of product")
    @GetMapping("/{id}")
    public String get(){
        return "success";
    }

    @Operation(summary="Add new product to application")
    @PostMapping("/add")
    public String add(){
        return "success";
    }

    @Operation(summary="Remove product from application")
    @DeleteMapping("/{id}")
    public String delete(){
        return "success";
    }

}
