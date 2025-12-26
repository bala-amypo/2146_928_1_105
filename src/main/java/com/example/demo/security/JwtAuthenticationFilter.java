package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String token = jwtUtil.getTokenFromRequest(request);

        if (token != null) {
            try {
                var claims = jwtUtil.validateAndGetClaims(token);
                String email = claims.get("email", String.class);
                String role = claims.get("role", String.class);

                var auth = new UsernamePasswordAuthenticationToken(
                        email,
                        null,
                        java.util.List.of(() -> "ROLE_" + role)
                );

                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);

            } catch (Exception ignored) {
                // Invalid token → request remains unauthenticated
            }
        }

        filterChain.doFilter(request, response);
    }
}
