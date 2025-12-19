package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AlertNotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private VisitLogEntity visitLog;

    private String alertMessage;
    private LocalDateTime sentAt;

    public Long getId() {
        return id;
    }

    public VisitLogEntity getVisitLog() {
        return visitLog;
    }

    public void setVisitLog(VisitLogEntity visitLog) {
        this.visitLog = visitLog;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
}
