package com.example.demo.model;

public class User {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String role;

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // 🔥 REQUIRED BY TESTS
        this.id = id;
    }

    public String getUsername() {  // 🔥 REQUIRED
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {  // 🔥 REQUIRED
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {       // 🔥 REQUIRED
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
