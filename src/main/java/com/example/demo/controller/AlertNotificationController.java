package com.example.demo.controller;

import com.example.demo.entity.AlertNotificationEntity;
import com.example.demo.entity.VisitLogEntity;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertNotificationController {

    private final AlertNotificationRepository alertRepository;
    private final VisitLogRepository visitLogRepository;

    public AlertNotificationController(
            AlertNotificationRepository alertRepository,
            VisitLogRepository visitLogRepository) {
        this.alertRepository = alertRepository;
        this.visitLogRepository = visitLogRepository;
    }

    @PostMapping("/send/{visitLogId}")
    public AlertNotificationEntity sendAlert(@PathVariable Long visitLogId) {

        VisitLogEntity visit = visitLogRepository.findById(visitLogId).orElseThrow();

        AlertNotificationEntity alert = new AlertNotificationEntity();
        alert.setVisitLog(visit);
        alert.setAlertMessage("Visitor arrived");
        alert.setSentAt(LocalDateTime.now());

        return alertRepository.save(alert);
    }

    @GetMapping("/{id}")
    public AlertNotificationEntity getAlert(@PathVariable Long id) {
        return alertRepository.findById(id).orElseThrow();
    }

    @GetMapping
    public List<AlertNotificationEntity> getAllAlerts() {
        return alertRepository.findAll();
    }
}
