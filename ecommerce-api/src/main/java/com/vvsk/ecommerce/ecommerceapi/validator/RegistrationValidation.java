package com.vvsk.ecommerce.ecommerceapi.validator;

import java.util.ArrayList;
import java.util.List;

import com.vvsk.ecommerce.ecommerceapi.dto.request.RegisterRequest;
import com.vvsk.ecommerce.ecommerceapi.dto.response.ErrorMessage;

public class RegistrationValidation {
	
	public static List<ErrorMessage> validate(RegisterRequest request){
		List<ErrorMessage> messages = new ArrayList<ErrorMessage>();
		
		if(request.getUsername()==null || request.getUsername().isEmpty()) {
			messages.add(new ErrorMessage("Username is required","request.username"));
		}
		
		if(request.getPassword()==null || request.getPassword().isEmpty()) {
			messages.add(new ErrorMessage("Password is required","request.password"));
		}
		else if(request.getPassword().length()<8) {
			messages.add(new ErrorMessage("Password should have minimum of 8 characters","request.password"));
		}
		
		return messages;
	}

}
