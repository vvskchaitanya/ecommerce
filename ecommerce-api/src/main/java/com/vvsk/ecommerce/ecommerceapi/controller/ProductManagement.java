package com.vvsk.ecommerce.ecommerceapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vvsk.ecommerce.ecommerceapi.dto.common.Product;
import com.vvsk.ecommerce.ecommerceapi.mapper.ProductMapper;
import com.vvsk.ecommerce.ecommerceapi.repository.ProductRepository;
import com.vvsk.ecommerce.ecommerceapi.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/products")
public class ProductManagement {

	@Autowired
	ProductService productService;

    @Operation(summary="Retrieve all products")
    @GetMapping
    public ResponseEntity<List<Product>> list(){
        List<Product> products = productService.getProducts();    
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
    
    @Operation(summary="Retrieve all products using pagination")
    @PreAuthorize("hasAnyRole({'USER','ADMIN'})")
    @GetMapping("/page")
    public ResponseEntity<List<Product>> list(@RequestParam String sort, @RequestParam Integer index, @RequestParam Integer count){
        List<Product> products = productService.getProducts(sort,index,count);    
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @Operation(summary="Retrieve information of product")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/info/{id}")
    public ResponseEntity<Product> get(@PathVariable("id") Integer id){
       Product product = this.productService.info(id);
       
       return product==null? 
    		   new ResponseEntity<Product>(HttpStatus.NOT_FOUND) 
    		   : new ResponseEntity<Product>(product,HttpStatus.OK);
    }

    @Operation(summary="Add new product to application")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public Product add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @Operation(summary="Remove product from application")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String delete(){
        return "success";
    }

}
