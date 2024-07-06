package com.vvsk.ecommerce.ecommerceapi.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.vvsk.ecommerce.ecommerceapi.dto.common.User;
import com.vvsk.ecommerce.ecommerceapi.entity.UserEntity;
import com.vvsk.ecommerce.ecommerceapi.repository.UserRepository;

public class UserServiceTest {
	
	UserService userService = new UserService();
	
	UserRepository userRepository = Mockito.mock(UserRepository.class);
	
	
	@BeforeEach
	public void setup() {		
		userService.userRepository = userRepository;

	}


	@Test
	public void get_success() {
		
		// Given
		
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1);
		userEntity.setName("chaitu");
		userEntity.setPassword("$2a$10$VWizXq9/uhlbTq8Qp8B72ORbQCAR7wbduTqMW2IkPe0SzkdDrHSre");
		userEntity.setRole("USER");
		
		Mockito.when(userRepository.findByName("chaitu"))
		.thenReturn(List.of(userEntity));
		
		
		// When get method is triggered for not existing username
		User user = userService.get("chaitu");
		
		// Then
		Assertions.assertNotNull(user);
		Assertions.assertEquals("USER", user.getRole());
		
	}
	
	
	@Test
	public void get_failed() {
		
		// Given
		UserRepository userRepository = Mockito.mock(UserRepository.class);
		Mockito.when(userRepository.findByName("vvsk"))
		.thenReturn(List.of());
		
		// When get method is triggered for not existing username
		User user = userService.get("vvsk");
		
		// Then
		Assertions.assertNull(user);
	}

}
