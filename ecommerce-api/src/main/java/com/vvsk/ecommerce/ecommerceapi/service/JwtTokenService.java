package com.vvsk.ecommerce.ecommerceapi.service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.ENC;

@Service
public class JwtTokenService {

    private static final String SECRET = "elzKUEbUJFd78m1oX46NFBLZJ38O0sk0";
    private static final long EXPIRATION_TIME = 864_000_000;

    private static SecretKey SECRET_KEY =new SecretKey() {
        @Override
        public String getAlgorithm() {
            return "RS256";
        }
        @Override
        public byte[] getEncoded() {
            return SECRET.getBytes();
        }
        @Override
        public String getFormat() {
            return "UFT-8";
        }
    };
    
    public String generateToken(String username) {
        return Jwts.builder()
        .claim("subject", "username")
        .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .encryptWith(SECRET_KEY, ENC.A128CBC_HS256).compact();
    }

}