package com.vvsk.ecommerce.ecommerceapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {
	
	String message;
	
	String field;
	
	
}
