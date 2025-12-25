package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "secret-key-demo";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24; // 1 day

    // ✅ EXACT SIGNATURE REQUIRED BY TESTS
    public String generateToken(String email, String role, long userId, String username) {

        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .claim("userId", userId)
                .claim("username", username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // ✅ MUST RETURN Jws<Claims>, NOT Claims
    public Jws<Claims> validateAndGetClaims(String token) {

        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token);
    }
}
