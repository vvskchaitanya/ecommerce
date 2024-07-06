package com.vvsk.ecommerce.ecommerceapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vvsk.ecommerce.ecommerceapi.dto.common.Product;
import com.vvsk.ecommerce.ecommerceapi.entity.ProductEntity;

@Mapper
public interface ProductMapper {
    
    Product map(ProductEntity productEntity);
	
	ProductEntity map(Product product);

}
