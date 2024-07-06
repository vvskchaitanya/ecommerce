package com.vvsk.ecommerce.ecommerceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vvsk.ecommerce.ecommerceapi.dto.common.User;
import com.vvsk.ecommerce.ecommerceapi.dto.request.RegisterRequest;
import com.vvsk.ecommerce.ecommerceapi.dto.response.ErrorCode;
import com.vvsk.ecommerce.ecommerceapi.dto.response.ErrorMessage;
import com.vvsk.ecommerce.ecommerceapi.dto.response.Response;
import com.vvsk.ecommerce.ecommerceapi.service.RegistrationService;
import com.vvsk.ecommerce.ecommerceapi.service.UserService;
import com.vvsk.ecommerce.ecommerceapi.validator.RegistrationValidation;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserManagement {

    @Autowired
    UserService userService;
    
    @Autowired
    RegistrationService registrationService;

    @Operation(summary="Retrieve all users")
    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public Response<List<User>> list(){
    	List<User> users = userService.list();
    	Response<List<User>> response= Response.success(users);
        return response;
    }

    @Operation(summary="Retrieve specific user details")
    @PreAuthorize("hasAnyRole({'USER','ADMIN'})")
    @GetMapping("/{username}")
    public Response<User> get(@PathVariable(name="username") String username){
        User user = userService.get(username);
        return user==null?  Response.fail(ErrorCode.USER_NOT_FOUND): Response.success(user);
    }

    @Operation(summary="Register (or) Sign up for new users")
    @PostMapping("/register")
    public Response<User> register(@RequestBody @Valid RegisterRequest request){
    	
    	List<ErrorMessage> errors = RegistrationValidation.validate(request);
    	
    	if(!CollectionUtils.isEmpty(errors)) {
    		return Response.fail(ErrorCode.REGISTRATION_FAILED, errors);
    	}
        User user = this.registrationService.register(request);
        return Response.success(user);
    }

    @Operation(summary="Remove user from application")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{username}")
    public Response<User> delete(){
        return Response.success(null);
    }

}
