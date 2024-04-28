package com.vvsk.ecommerce.ecommerceapi.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtTokenService {

    private static final String SECRET = "elzKUEbUJFd78m1oX46NFBLZJ38O0sk0";
    private static final long EXPIRATION_TIME = 864_000_000;

    
    public String generateToken(String username) {
        return Jwts.builder()
        .claim("subject", username)
        .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(Keys.hmacShaKeyFor(SECRET.getBytes())).compact();
    }

}