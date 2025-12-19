package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private VisitorEntity visitor;

    @ManyToOne
    private HostEntity host;

    private String status;

    public Long getId() {
        return id;
    }

    public VisitorEntity getVisitor() {
        return visitor;
    }

    public void setVisitor(VisitorEntity visitor) {
        this.visitor = visitor;
    }

    public HostEntity getHost() {
        return host;
    }

    public void setHost(HostEntity host) {
        this.host = host;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
