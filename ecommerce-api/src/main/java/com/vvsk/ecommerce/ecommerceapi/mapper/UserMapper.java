package com.vvsk.ecommerce.ecommerceapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vvsk.ecommerce.ecommerceapi.dto.common.User;
import com.vvsk.ecommerce.ecommerceapi.entity.UserEntity;

@Mapper
public interface UserMapper {

    @Mapping(target="name",source="username")
    User map(UserEntity userEntity);
    UserEntity map(User user);

}
