package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.JwtException;

import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class JwtUtil {

    // These fields are set via ReflectionTestUtils in tests
    private String secret;
    private long jwtExpirationMs;

    public JwtUtil() {
    }

    // =========================
    // GENERATE TOKEN
    // =========================
    public String generateToken(String username, String role, Long userId, String email) {

        byte[] keyBytes = secret.getBytes();
        Key key = new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .claim("userId", userId)
                .claim("email", email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // =========================
    // VALIDATE & GET CLAIMS
    // =========================
    public io.jsonwebtoken.Jws<Claims> validateAndGetClaims(String token) throws JwtException {

        byte[] keyBytes = secret.getBytes();
        Key key = new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }
}
