package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users", description = "User management APIs")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 🔹 Register new user
    @PostMapping
    @Operation(summary = "Register a new user")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // 🔹 Get user by ID
    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID")
    public User getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    // 🔹 Get user by email
    @GetMapping("/email/{email}")
    @Operation(summary = "Get user by email")
    public User getByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}
