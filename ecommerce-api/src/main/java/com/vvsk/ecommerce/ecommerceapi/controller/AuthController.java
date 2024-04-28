package com.vvsk.ecommerce.ecommerceapi.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vvsk.ecommerce.ecommerceapi.dto.request.LoginRequest;
import com.vvsk.ecommerce.ecommerceapi.service.LoginService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/authentication")
public class AuthController {

    @Autowired
    LoginService loginService;

    @Operation(summary = "Login endpoint for the users")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest request){
        String token = loginService.authenticate(request.getUsername(), request.getPassword());
        return Objects.isNull(token)? new ResponseEntity<>(HttpStatus.UNAUTHORIZED): new ResponseEntity<>(token,HttpStatus.OK);    
    }

    @Operation(summary = "Session validation endpoint for the users")
    @PostMapping("/verify/{token}")
    public String verify(@PathVariable("token") String token){
        return "success";
    }

}
