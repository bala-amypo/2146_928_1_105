package com.example.demo.model;

public class Visitor {
    private Long id;
    private String fullName;
    private String phone;
    private String idProofNumber;
    private String email;

    public Visitor() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getIdProofNumber() { return idProofNumber; }
    public void setIdProofNumber(String idProofNumber) { this.idProofNumber = idProofNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
