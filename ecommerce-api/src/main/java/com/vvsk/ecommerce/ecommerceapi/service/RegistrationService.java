package com.vvsk.ecommerce.ecommerceapi.service;

import com.vvsk.ecommerce.ecommerceapi.dto.request.RegisterRequest;

public interface RegistrationService {
	
	Boolean register(RegisterRequest customer);

}
