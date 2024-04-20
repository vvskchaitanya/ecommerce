package com.vvsk.ecommerce.ecommerceapi.service;

import java.util.Date;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenService {

    private static final String SECRET = "jwt-secret-key";
    private static final long EXPIRATION_TIME = 864_000_000;
    
    public String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.RS256, SECRET)
            .compact();
    }


    public String extractUsername(String token) {
        return Jwts.parser()
            .setSigningKey(SECRET)
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }
}