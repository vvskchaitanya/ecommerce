package com.vvsk.ecommerce.ecommerceapi.service;

import com.vvsk.ecommerce.ecommerceapi.dto.common.User;
import com.vvsk.ecommerce.ecommerceapi.dto.request.RegisterRequest;

public interface RegistrationService {
	
	User register(RegisterRequest customer);

}
