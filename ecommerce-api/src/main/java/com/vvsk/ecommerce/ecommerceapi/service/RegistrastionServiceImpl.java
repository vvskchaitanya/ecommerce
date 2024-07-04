package com.vvsk.ecommerce.ecommerceapi.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vvsk.ecommerce.ecommerceapi.dto.common.Customer;
import com.vvsk.ecommerce.ecommerceapi.dto.request.RegisterRequest;
import com.vvsk.ecommerce.ecommerceapi.entity.CustomerEntity;
import com.vvsk.ecommerce.ecommerceapi.entity.UserEntity;
import com.vvsk.ecommerce.ecommerceapi.mapper.CustomerMapper;
import com.vvsk.ecommerce.ecommerceapi.mapper.UserMapper;
import com.vvsk.ecommerce.ecommerceapi.repository.CustomerRepository;
import com.vvsk.ecommerce.ecommerceapi.repository.UserRepository;

@Service
public class RegistrastionServiceImpl implements RegistrationService {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	CustomerMapper mapper = Mappers.getMapper(CustomerMapper.class);
	UserMapper userMapper = Mappers.getMapper(UserMapper.class);
	
	@Override
	public Boolean register(RegisterRequest request) {
		
		CustomerEntity customerEntity = mapper.map(request.getCustomer());
		
		UserEntity userEntity  = userMapper.map(request);
		userEntity.setPassword(encoder.encode(request.getPassword()));
		userEntity.setRole("USER");
		
		this.userRepo.save(userEntity);
		
		this.customerRepo.save(customerEntity);
		
		return true;
		
	}

}
