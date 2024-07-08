package com.vvsk.ecommerce.ecommerceapi.validator;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.vvsk.ecommerce.ecommerceapi.dto.request.RegisterRequest;
import com.vvsk.ecommerce.ecommerceapi.dto.response.ErrorMessage;

public class RegisterValidationTest {
	
	@Test
	public void test_EmptyUsername() {
		
		// Given there is registration request without user name
		RegisterRequest request = new RegisterRequest();
		
		// When validation has been triggered on that request
		List<ErrorMessage> messages = RegistrationValidation.validate(request);
		
		// Then we should validation message for that request
		Assertions.assertEquals("Username is required", messages.get(0).getMessage());
		
	}
	
	@Test
	public void test_EmptyPassword() {
		
		// Given there is registration request without password
		RegisterRequest request = new RegisterRequest();
		request.setUsername("myusername");
		request.setPassword(null);
		
		// When validation has been triggered on that request
		List<ErrorMessage> messages = RegistrationValidation.validate(request);
		
		// Then we should validation message for that request
		Assertions.assertEquals("Password is required", messages.get(0).getMessage());
		
	}
	
	@Test
	public void test_PasswordLength() {
		
		// Given there is registration request without password
		RegisterRequest request = new RegisterRequest();
		request.setUsername("myusername");
		request.setPassword("test");
		
		// When validation has been triggered on that request
		List<ErrorMessage> messages = RegistrationValidation.validate(request);
		
		// Then we should validation message for that request
		Assertions.assertEquals("Password should have minimum of 8 characters", messages.get(0).getMessage());
		
	}

}
