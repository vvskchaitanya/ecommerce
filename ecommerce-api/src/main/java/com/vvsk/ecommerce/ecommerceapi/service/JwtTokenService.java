package com.vvsk.ecommerce.ecommerceapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.vvsk.ecommerce.ecommerceapi.configuration.JwtAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtTokenService {

    private static final String SECRET = "elzKUEbUJFd78m1oX46NFBLZJ38O0sk0";
    private static final long EXPIRATION_TIME = 864_000_000;
    private static final JwtParser JWT_PARSER = Jwts.parser().verifyWith(Keys.hmacShaKeyFor(SECRET.getBytes())).build();

    
    public String generateToken(String username, String role) {
        return Jwts.builder()
        .claim("subject", username)
        .claim("id",username)
        .claim("username",username)
        .claim("role",role)
        .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(Keys.hmacShaKeyFor(SECRET.getBytes())).compact();
    }

    public JwtAuthenticationToken verify(String token){
        Jws<Claims> jws = JWT_PARSER.parse(token).accept(Jws.CLAIMS);
        String username = (String) jws.getPayload().get("username");
        String role = (String) jws.getPayload().get("role");
        return new JwtAuthenticationToken(username, List.of(new SimpleGrantedAuthority("ROLE_"+role)));
    }

}