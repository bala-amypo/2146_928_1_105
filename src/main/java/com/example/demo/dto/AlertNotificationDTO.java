// File: AlertNotificationDTO.java
package com.example.demo.dto;

import java.time.LocalDateTime;

public class AlertNotificationDTO {

    private Long id;
    private String alertMessage;
    private String sentTo;
    private LocalDateTime sentAt;
    private Long visitLogId;

    public AlertNotificationDTO() {}

    public AlertNotificationDTO(Long id, String alertMessage,
                                String sentTo, LocalDateTime sentAt,
                                Long visitLogId) {
        this.id = id;
        this.alertMessage = alertMessage;
        this.sentTo = sentTo;
        this.sentAt = sentAt;
        this.visitLogId = visitLogId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public Long getVisitLogId() {
        return visitLogId;
    }

    public void setVisitLogId(Long visitLogId) {
        this.visitLogId = visitLogId;
    }
}
