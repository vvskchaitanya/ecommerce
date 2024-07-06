package com.vvsk.ecommerce.ecommerceapi._init;

import java.util.List;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vvsk.ecommerce.ecommerceapi.entity.ProductEntity;
import com.vvsk.ecommerce.ecommerceapi.entity.UserEntity;
import com.vvsk.ecommerce.ecommerceapi.repository.ProductRepository;
import com.vvsk.ecommerce.ecommerceapi.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {

    @Autowired
    ProductRepository productRepository;
    
    @Autowired
    BCryptPasswordEncoder encoder;
    
    @Autowired
    UserRepository userRepository;

    @PostConstruct()
    public void load(){
        this.products();
        this.users();
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
	
	private void users() {
		UserEntity u = new UserEntity();
        u.setName("ADMIN");
        u.setPassword(encoder.encode("ADMIN"));
        u.setRole("ADMIN");
        this.userRepository.save(u);
        u = new UserEntity();
        u.setName("USER");
        u.setPassword(encoder.encode("USER"));
        u.setRole("USER");
        this.userRepository.save(u);
	}



}
