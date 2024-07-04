package com.vvsk.ecommerce.ecommerceapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.vvsk.ecommerce.ecommerceapi.dto.common.User;
import com.vvsk.ecommerce.ecommerceapi.dto.request.RegisterRequest;
import com.vvsk.ecommerce.ecommerceapi.entity.UserEntity;

@Mapper
public interface UserMapper {

    User map(UserEntity userEntity);
    
    @Mapping(source="username",target="name")
    UserEntity map(RegisterRequest request);
    

}
