package com.vvsk.ecommerce.ecommerceapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vvsk.ecommerce.ecommerceapi.entity.UserEntity;
import com.vvsk.ecommerce.ecommerceapi.repository.UserRepository;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    JwtTokenService tokenService;

    public String authenticate(String username, String password){
        List<UserEntity> users = this.userRepository.findByName(username);
        
        if(users.size()>0){
            UserEntity user = users.get(0);
            if(encoder.matches(password, user.getPassword())){
                return tokenService.generateToken(user.getName());
            };
        }

        return null;
    }

}
