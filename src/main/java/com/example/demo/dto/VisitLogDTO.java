// File: VisitLogDTO.java
package com.example.demo.dto;

import java.time.LocalDateTime;

public class VisitLogDTO {

    private Long id;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private boolean accessGranted;
    private boolean alertSent;
    private Long visitorId;
    private Long hostId;
    private String purpose;

    public VisitLogDTO() {}

    public VisitLogDTO(Long id, LocalDateTime checkInTime, LocalDateTime checkOutTime,
                       boolean accessGranted, boolean alertSent,
                       Long visitorId, Long hostId, String purpose) {
        this.id = id;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.accessGranted = accessGranted;
        this.alertSent = alertSent;
        this.visitorId = visitorId;
        this.hostId = hostId;
        this.purpose = purpose;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isAlertSent() {
        return alertSent;
    }

    public void setAlertSent(boolean alertSent) {
        this.alertSent = alertSent;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
