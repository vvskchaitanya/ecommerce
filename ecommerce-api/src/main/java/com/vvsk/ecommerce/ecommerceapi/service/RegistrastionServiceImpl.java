package com.vvsk.ecommerce.ecommerceapi.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vvsk.ecommerce.ecommerceapi.dto.common.Profile;
import com.vvsk.ecommerce.ecommerceapi.dto.common.User;
import com.vvsk.ecommerce.ecommerceapi.dto.request.RegisterRequest;
import com.vvsk.ecommerce.ecommerceapi.entity.ProfileEntity;
import com.vvsk.ecommerce.ecommerceapi.entity.UserEntity;
import com.vvsk.ecommerce.ecommerceapi.mapper.ProfileMapper;
import com.vvsk.ecommerce.ecommerceapi.mapper.UserMapper;
import com.vvsk.ecommerce.ecommerceapi.repository.ProfileRepository;
import com.vvsk.ecommerce.ecommerceapi.repository.UserRepository;

@Service
public class RegistrastionServiceImpl implements RegistrationService {
	
	@Autowired
	ProfileRepository profileRepository;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	UserMapper userMapper = Mappers.getMapper(UserMapper.class);
	
	ProfileMapper profileMapper = Mappers.getMapper(ProfileMapper.class);
	
	@Override
	public User register(RegisterRequest request) {
		
		ProfileEntity profileEntity = profileMapper.map(request);
		
		UserEntity userEntity  = userMapper.map(request);
		userEntity.setPassword(encoder.encode(request.getPassword()));

		// By Default User will get user role
		userEntity.setRole("USER");
		
		userEntity = this.userRepo.save(userEntity);
		
		//this.profileRepository.save(profileEntity);
		
		return userMapper.map(userEntity);
		
	}

}
