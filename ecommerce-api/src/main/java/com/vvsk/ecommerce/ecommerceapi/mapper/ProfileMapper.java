package com.vvsk.ecommerce.ecommerceapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vvsk.ecommerce.ecommerceapi.dto.common.Profile;
import com.vvsk.ecommerce.ecommerceapi.entity.ProfileEntity;
import com.vvsk.ecommerce.ecommerceapi.entity.UserEntity;

@Mapper
public interface ProfileMapper {
	
    @Mapping(source="name",target="firstName")
    @Mapping(source="id",target="id",ignore=true)
    ProfileEntity map(UserEntity user);
    
    Profile map(ProfileEntity profileEntity);

}
