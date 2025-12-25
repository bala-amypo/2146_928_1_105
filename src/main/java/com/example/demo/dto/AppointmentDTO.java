// File: AppointmentDTO.java
package com.example.demo.dto;

import java.time.LocalDate;

public class AppointmentDTO {

    private Long id;
    private LocalDate appointmentDate;
    private String purpose;
    private String status;
    private Long visitorId;
    private Long hostId;

    public AppointmentDTO() {}

    public AppointmentDTO(Long id, LocalDate appointmentDate, String purpose,
                          String status, Long visitorId, Long hostId) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.purpose = purpose;
        this.status = status;
        this.visitorId = visitorId;
        this.hostId = hostId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
