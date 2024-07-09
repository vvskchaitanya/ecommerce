package com.vvsk.ecommerce.ecommerceapi.controller;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.vvsk.ecommerce.ecommerceapi.dto.common.Product;

@SpringBootTest
public class ProductManagementTest {

	private RestTemplate restTemplate = new RestTemplate();


    @Test
    void testGet() {

        ResponseEntity<List> response = this.restTemplate.getForEntity("https://8080-vvskchaitanya-ecommerce-27ymwtmnu9f.ws-us115.gitpod.io/products",
        List.class);

        Assertions.assertTrue(response.getBody().size()>30);

        Product product  = (Product) response.getBody().get(0);

        Assertions.assertNotNull(product.getName());

        Assertions.assertNotNull(product.getPrice());

        Assertions.assertNotNull(product.getCategory());



    }

    @Test
    void testList() {

    }
}
