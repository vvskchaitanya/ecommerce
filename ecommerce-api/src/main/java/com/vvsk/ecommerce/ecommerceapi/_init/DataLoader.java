package com.vvsk.ecommerce.ecommerceapi._init;

import java.util.List;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vvsk.ecommerce.ecommerceapi.entity.ProductEntity;
import com.vvsk.ecommerce.ecommerceapi.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {

    @Autowired
    ProductRepository productRepository;

    @PostConstruct()
    public void load(){
        this.products();
    }

    private void products(){
        String f = this.getClass().getClassLoader().getResource("products.json").getFile();
        System.out.print(f);
        try{
            List<ProductEntity> products = new ObjectMapper().readValue(new File(f), new TypeReference<List<ProductEntity>>(){});
            products.forEach(p->{
                productRepository.save(p);
            });
        }catch(Exception e){
            e.printStackTrace();
        }
        

    }



}
