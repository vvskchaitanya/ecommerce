package com.vvsk.ecommerce.ecommerceapi.configuration;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.vvsk.ecommerce.ecommerceapi.service.JwtTokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Service
@Order(Ordered.HIGHEST_PRECEDENCE)
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    JwtTokenService jwtTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            try {
                JwtAuthenticationToken authentication = jwtTokenService.verify(token);
                authentication.setAuthenticated(true);  
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        filterChain.doFilter(request, response);
    }
}

