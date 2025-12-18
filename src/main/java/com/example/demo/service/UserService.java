package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.AuthRequest;

public interface UserService {
    void register(RegisterRequest request);
    String login(AuthRequest request);
}
