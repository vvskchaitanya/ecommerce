package com.vvsk.ecommerce.ecommerceapi.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vvsk.ecommerce.ecommerceapi.dto.common.User;
import com.vvsk.ecommerce.ecommerceapi.entity.UserEntity;
import com.vvsk.ecommerce.ecommerceapi.mapper.UserMapper;
import com.vvsk.ecommerce.ecommerceapi.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public List<User> list(){
        return userRepository.findAll().stream().map(mapper::map).collect(Collectors.toList());
    }

    public User get(String username){
        User user = null;
        List<UserEntity> users = userRepository.findByUsername(username);
        if(users.size()>0){
            user=mapper.map(users.get(0));
        }
        return user;
    }

}
