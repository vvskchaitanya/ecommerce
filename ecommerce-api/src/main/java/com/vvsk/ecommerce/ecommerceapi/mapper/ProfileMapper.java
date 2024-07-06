package com.vvsk.ecommerce.ecommerceapi.mapper;

import org.mapstruct.Mapper;

import com.vvsk.ecommerce.ecommerceapi.dto.common.Customer;
import com.vvsk.ecommerce.ecommerceapi.dto.request.RegisterRequest;
import com.vvsk.ecommerce.ecommerceapi.entity.ProfileEntity;

@Mapper
public interface ProfileMapper {
	
    ProfileEntity map(RegisterRequest register);
    
    Customer map(ProfileEntity customer);

}
