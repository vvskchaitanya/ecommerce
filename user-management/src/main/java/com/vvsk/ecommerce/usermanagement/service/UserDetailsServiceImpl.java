package com.vvsk.ecommerce.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vvsk.ecommerce.usermanagement.entity.UserEntity;
import com.vvsk.ecommerce.usermanagement.repository.UserRepository;

import jakarta.annotation.PostConstruct;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @PostConstruct
    void initialize(){
        UserEntity u = new UserEntity();
        u.setUsername("ADMIN");
        u.setPassword(encoder.encode("ADMIN"));
        u.setRole("ADMIN");
        u.setEmail("admin@admin.com");
        this.userRepository.save(u);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserEntity> users = this.userRepository.findByUsername(username);
        
        if(users.size()>0){
            UserEntity user = users.get(0);
            return new User(user.getUsername(),user.getPassword(),List.of(new SimpleGrantedAuthority(user.getRole())));
        }else{
            throw new UsernameNotFoundException("User not found: "+username);
        }
    }

}
