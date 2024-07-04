package com.vvsk.ecommerce.ecommerceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vvsk.ecommerce.ecommerceapi.dto.common.User;
import com.vvsk.ecommerce.ecommerceapi.dto.request.RegisterRequest;
import com.vvsk.ecommerce.ecommerceapi.service.RegistrationService;
import com.vvsk.ecommerce.ecommerceapi.service.UserService;

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
    public List<User> list(){
        return userService.list();
    }

    @Operation(summary="Retrieve specific user details")
    @PreAuthorize("hasAnyRole({'USER','ADMIN'})")
    @GetMapping("/{username}")
    public ResponseEntity<User> get(@PathVariable(name="username") String username){
        User user = userService.get(username);
        return user==null?  new ResponseEntity<>(HttpStatus.NOT_FOUND): new ResponseEntity<>(user,HttpStatus.OK);
    }

    @Operation(summary="Register (or) Sign up for new users")
    @PostMapping("/register")
    public String register(@RequestBody @Valid RegisterRequest request){
        this.registrationService.register(request);
        return "SUCCESS";
    }

    @Operation(summary="Remove user from application")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{username}")
    public String delete(){
        return "success";
    }

}
