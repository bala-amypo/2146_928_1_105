package com.example.demo.controller;

import com.example.demo.entity.AlertNotificationEntity;
import com.example.demo.repository.AlertNotificationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertNotificationController {

    private final AlertNotificationRepository alertNotificationRepository;

    public AlertNotificationController(AlertNotificationRepository alertNotificationRepository) {
        this.alertNotificationRepository = alertNotificationRepository;
    }

    @GetMapping
    public List<AlertNotificationEntity> getAllAlerts() {
        return alertNotificationRepository.findAll();
    }
}
