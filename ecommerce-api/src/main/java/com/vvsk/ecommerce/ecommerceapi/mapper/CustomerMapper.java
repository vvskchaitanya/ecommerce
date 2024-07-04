package com.vvsk.ecommerce.ecommerceapi.mapper;

import org.mapstruct.Mapper;

import com.vvsk.ecommerce.ecommerceapi.dto.common.Customer;
import com.vvsk.ecommerce.ecommerceapi.entity.CustomerEntity;

@Mapper
public interface CustomerMapper {
	
    CustomerEntity map(Customer customer);
    
    Customer map(CustomerEntity customer);

}
