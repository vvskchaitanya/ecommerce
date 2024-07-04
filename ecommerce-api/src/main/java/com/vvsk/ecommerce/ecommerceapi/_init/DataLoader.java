package com.vvsk.ecommerce.ecommerceapi._init;

import java.util.List;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vvsk.ecommerce.ecommerceapi.entity.CategoryEntity;
import com.vvsk.ecommerce.ecommerceapi.entity.ProductEntity;
import com.vvsk.ecommerce.ecommerceapi.entity.UserEntity;
import com.vvsk.ecommerce.ecommerceapi.repository.CategoryRepository;
import com.vvsk.ecommerce.ecommerceapi.repository.ProductRepository;
import com.vvsk.ecommerce.ecommerceapi.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {

    @Autowired
    ProductRepository productRepository;
    
    @Autowired
    CategoryRepository categoryRepository;
    
    @Autowired
    BCryptPasswordEncoder encoder;
    
    @Autowired
    UserRepository userRepository;

    @PostConstruct()
    public void load(){
        this.products(this.categories());
        this.users();
    }

    private CategoryEntity categories() {
    	
    	CategoryEntity category = new CategoryEntity();
    	category.setName("Mobiles");
    	category.setDescription("All branded mobile phones");
    	category = this.categoryRepository.save(category);
    	return category;
		
		
	}

	private void products(CategoryEntity categoryEntity){
        String f = this.getClass().getClassLoader().getResource("products.json").getFile();
        System.out.print(f);
        try{
            List<ProductEntity> products = new ObjectMapper().readValue(new File(f), new TypeReference<List<ProductEntity>>(){});
            products.forEach(p->{
            	p.setCategory(categoryEntity);
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
        u.setEmail("admin@admin.com");
        this.userRepository.save(u);
        u = new UserEntity();
        u.setName("USER");
        u.setPassword(encoder.encode("USER"));
        u.setRole("USER");
        u.setEmail("user@user.com");
        this.userRepository.save(u);
	}



}
