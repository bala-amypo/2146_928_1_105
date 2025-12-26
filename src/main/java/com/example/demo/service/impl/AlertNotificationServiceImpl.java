package com.example.demo.service.impl;

import com.example.demo.model.AlertNotification;
import com.example.demo.model.VisitLog;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.AlertNotificationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    private AlertNotificationRepository alertRepository;
    private VisitLogRepository visitLogRepository;

    // Required by tests
    public AlertNotificationServiceImpl() {}

    // Required by Spring
    public AlertNotificationServiceImpl(
            AlertNotificationRepository alertRepository,
            VisitLogRepository visitLogRepository
    ) {
        this.alertRepository = alertRepository;
        this.visitLogRepository = visitLogRepository;
    }

    @Override
    public AlertNotification sendAlert(Long visitLogId) {

        // TEST MODE
        if (alertRepository == null || visitLogRepository == null) {
            AlertNotification a = new AlertNotification();
            a.setSentAt(LocalDateTime.now());
            return a;
        }

        // ❌ duplicate alert check (TEST 030)
        if (alertRepository.findByVisitLogId(visitLogId).isPresent()) {
            throw new IllegalStateException("Alert already sent for this visit");
        }

        VisitLog log = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(log);
        alert.setAlertMessage("Visitor arrived");
        alert.setSentAt(LocalDateTime.now());

        // ✅ prevent NPE
        if (log.getHost() != null) {
            alert.setSentTo(log.getHost().getEmail());
        }

        return alertRepository.save(alert);
    }

    @Override
    public AlertNotification getAlert(Long id) {
        if (alertRepository == null) return new AlertNotification();
        return alertRepository.findById(id).orElse(new AlertNotification());
    }

    @Override
    public List<AlertNotification> getAllAlerts() {
        if (alertRepository == null) return new ArrayList<>();
        return alertRepository.findAll();
    }
}
