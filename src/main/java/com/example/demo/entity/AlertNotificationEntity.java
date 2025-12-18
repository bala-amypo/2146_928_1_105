package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AlertNotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private VisitLogEntity visitLog;

    private String sentTo;
    private String alertMessage;
    private LocalDateTime sentAt;

    @PrePersist
    public void onSend() {
        sentAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }
}
