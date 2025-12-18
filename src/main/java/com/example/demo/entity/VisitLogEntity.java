package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VisitLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private VisitorEntity visitor;

    @ManyToOne
    private HostEntity host;

    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private String purpose;
    private Boolean accessGranted;
    private Boolean alertSent = false;

    @PrePersist
    public void onCheckIn() {
        checkInTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public Boolean getAlertSent() {
        return alertSent;
    }

    public void setCheckOutTime(LocalDateTime time) {
        this.checkOutTime = time;
    }

    public void setAlertSent(Boolean alertSent) {
        this.alertSent = alertSent;
    }
}
