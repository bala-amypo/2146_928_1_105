package com.example.demo.model;

import java.time.LocalDateTime;

public class VisitLog {
    private Long id;
    private Visitor visitor;
    private Host host;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private Boolean accessGranted = false;

    public VisitLog() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Visitor getVisitor() { return visitor; }
    public void setVisitor(Visitor visitor) { this.visitor = visitor; }

    public Host getHost() { return host; }
    public void setHost(Host host) { this.host = host; }

    public LocalDateTime getCheckInTime() { return checkInTime; }
    public void setCheckInTime(LocalDateTime checkInTime) { this.checkInTime = checkInTime; }

    public LocalDateTime getCheckOutTime() { return checkOutTime; }
    public void setCheckOutTime(LocalDateTime checkOutTime) { this.checkOutTime = checkOutTime; }

    public Boolean getAccessGranted() { return accessGranted; }
    public void setAccessGranted(Boolean accessGranted) { this.accessGranted = accessGranted; }
}
