package com.example.demo.util;

import io.jsonwebtoken.Claims;

public class JwtUtil {

    private final com.example.demo.security.JwtUtil jwtUtil =
            new com.example.demo.security.JwtUtil();

    public String generateToken(String email, String role, long userId, String username) {
        return jwtUtil.generateToken(email, role, userId, username);
    }

    public Claims validateAndGetClaims(String token) {
        return jwtUtil.validateAndGetClaims(token);
    }
}
