package com.vvsk.ecommerce.ecommerceapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vvsk.ecommerce.ecommerceapi.entity.UserEntity;
import com.vvsk.ecommerce.ecommerceapi.repository.UserRepository;

import jakarta.annotation.PostConstruct;


@Service
public class UserDetailsServiceImpl{

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @PostConstruct
    void initialize(){
        UserEntity u = new UserEntity();
        u.setName("ADMIN");
        u.setPassword(encoder.encode("ADMIN"));
        u.setRole("ADMIN");
        u.setEmail("admin@admin.com");
        this.userRepository.save(u);
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserEntity> users = this.userRepository.findByName(username);
        
        if(users.size()>0){
            UserEntity user = users.get(0);
            return new User(user.getName(),user.getPassword(),List.of(new SimpleGrantedAuthority(user.getRole())));
        }else{
            throw new UsernameNotFoundException("User not found: "+username);
        }
    }

}
