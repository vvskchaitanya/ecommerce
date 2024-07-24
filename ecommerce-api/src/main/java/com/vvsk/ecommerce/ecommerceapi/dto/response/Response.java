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

	public ErrorCode getCode() {
		return code;
	}

	public void setCode(ErrorCode code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<ErrorMessage> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorMessage> errors) {
		this.errors = errors;
	}
	
}
