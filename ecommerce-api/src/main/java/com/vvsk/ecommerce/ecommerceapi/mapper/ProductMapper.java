package com.vvsk.ecommerce.ecommerceapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vvsk.ecommerce.ecommerceapi.dto.common.Product;
import com.vvsk.ecommerce.ecommerceapi.entity.ProductEntity;

@Mapper
public interface ProductMapper {
    
	@Mapping(source="category.name",target="category")
    Product map(ProductEntity productEntity);
	
	@Mapping(source="category",ignore = true, target = "category")
	ProductEntity map(Product product);

}
