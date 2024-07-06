package com.vvsk.ecommerce.ecommerceapi.dto.response;

import java.util.List;

import lombok.Builder;

public class Response<T> {
	
	private ErrorCode code;

	private boolean success;
	
	private T data;

	private List<ErrorMessage> errors;
	
	public static <K> Response<K> success(K data){
		Response<K> response = new Response<K>(); 
		response.success = true;
		response.data = data;
		return response;
	}
	
	public static <K> Response<K> fail(ErrorCode code){
		Response<K> response = new Response<K>(); 
		response.code = code;
		response.success = false;
		return response;
	}
	
	public static <K> Response<K> fail(ErrorCode code, List<ErrorMessage> errors){
		Response<K> response = new Response<K>(); 
		response.code = code;
		response.success = false;
		response.errors = errors;
		return response;
	}
	
}
