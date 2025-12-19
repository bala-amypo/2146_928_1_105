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
    private boolean accessGranted;

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

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public boolean isAccessGranted() {
        return accessGranted;
    }

    public void setAccessGranted(boolean accessGranted) {
        this.accessGranted = accessGranted;
    }
}
