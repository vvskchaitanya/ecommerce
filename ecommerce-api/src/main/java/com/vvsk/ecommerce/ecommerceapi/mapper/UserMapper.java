package com.vvsk.ecommerce.ecommerceapi.mapper;

import org.mapstruct.Mapper;

import com.vvsk.ecommerce.ecommerceapi.dto.common.User;
import com.vvsk.ecommerce.ecommerceapi.entity.UserEntity;

@Mapper
public interface UserMapper {

    User map(UserEntity userEntity);

}
