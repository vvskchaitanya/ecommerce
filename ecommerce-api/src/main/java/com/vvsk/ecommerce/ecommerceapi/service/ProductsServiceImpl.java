package com.vvsk.ecommerce.ecommerceapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vvsk.ecommerce.ecommerceapi.dto.common.Product;
import com.vvsk.ecommerce.ecommerceapi.entity.ProductEntity;
import com.vvsk.ecommerce.ecommerceapi.mapper.ProductMapper;
import com.vvsk.ecommerce.ecommerceapi.repository.ProductRepository;

@Service
public class ProductsServiceImpl implements ProductService {
	

	ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Autowired
    ProductRepository productRepository;
    
	@Override
	public List<Product> getProducts() {
		return productRepository.findAll().stream().map(mapper::map).collect(Collectors.toList()); 
	}

	@Override
	public List<Product> getProducts(String sort) {
		List<ProductEntity> products;
		
		switch(sort) {
		case "ASC":
			products = productRepository.findAll(PageRequest.of(0, 10, Sort.by("price"))).getContent();
			break;
		case "DSC":
			products = productRepository.findAll(PageRequest.of(0, 10, Sort.by("price").descending())).getContent();
			break;
		default:
			products = new ArrayList<ProductEntity>();
			break;
		}
		
		return products.stream().map(mapper::map).collect(Collectors.toList());
	}

	@Override
	public List<Product> getProducts(String sort, Integer index, Integer count) {
		List<ProductEntity> products;
		
		switch(sort) {
		case "ASC":
			products = productRepository.findAll(PageRequest.of(index, count, Sort.by("price"))).getContent();
			break;
		case "DSC":
			products = productRepository.findAll(PageRequest.of(index, count, Sort.by("price").descending())).getContent();
			break;
		default:
			products = new ArrayList<ProductEntity>();
			break;
		}
		
		return products.stream().map(mapper::map).collect(Collectors.toList());
	}

	@Override
	public Product add(Product product) {
		ProductEntity productEntity = mapper.map(product);
		
		productEntity = this.productRepository.save(productEntity);
		
		return mapper.map(productEntity);
	}

	@Override
	public Product info(Integer id) {
		
		Optional<ProductEntity> productOptional = this.productRepository.findById(id);
		
		return productOptional.isPresent()? mapper.map(productOptional.get()): null;
		
	}

	@Override
	public List<Product> search(String name) {
		
		List<ProductEntity> productEntities = productRepository.searchByName(name);

		return productEntities.stream().map(mapper::map).collect(Collectors.toList());


	}
	
	

}
