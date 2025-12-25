// File: HostDTO.java
package com.example.demo.dto;

public class HostDTO {

    private Long id;
    private String hostName;
    private String email;
    private String phone;

    public HostDTO() {}

    public HostDTO(Long id, String hostName, String email, String phone) {
        this.id = id;
        this.hostName = hostName;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
