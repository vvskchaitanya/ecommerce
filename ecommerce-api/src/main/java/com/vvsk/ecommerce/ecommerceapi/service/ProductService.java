package com.vvsk.ecommerce.ecommerceapi.service;

import java.util.List;

import com.vvsk.ecommerce.ecommerceapi.dto.common.Product;

public interface ProductService {
	
	List<Product> getProducts();
	
	List<Product> getProducts(String sort);
	
	List<Product> getProducts(String sort, Integer index, Integer count);
	
	Product add(Product product);
	
	Product info(Integer id);

}
