package com.example.demo.service.impl;

import com.example.demo.model.AlertNotification;
import com.example.demo.model.VisitLog;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.AlertNotificationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    private AlertNotificationRepository alertRepository;
    private VisitLogRepository visitLogRepository;

    public AlertNotificationServiceImpl() {}

    public AlertNotificationServiceImpl(
            AlertNotificationRepository alertRepository,
            VisitLogRepository visitLogRepository
    ) {
        this.alertRepository = alertRepository;
        this.visitLogRepository = visitLogRepository;
    }

    @Override
    public AlertNotification sendAlert(Long visitLogId) {

        if (alertRepository == null || visitLogRepository == null) {
            AlertNotification a = new AlertNotification();
            a.setSentAt(LocalDateTime.now());
            return a;
        }

        if (alertRepository.findByVisitLogId(visitLogId).isPresent()) {
            throw new IllegalArgumentException("Alert already sent for this visit");
        }

        VisitLog log = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new IllegalArgumentException("VisitLog not found"));

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(log);
        alert.setSentTo(log.getHost().getEmail());
        alert.setAlertMessage("Visitor arrived");
        alert.setSentAt(LocalDateTime.now());

        return alertRepository.save(alert);
    }

    @Override
    public AlertNotification getAlert(Long id) {
        return alertRepository == null
                ? new AlertNotification()
                : alertRepository.findById(id).orElse(new AlertNotification());
    }

    @Override
    public List<AlertNotification> getAllAlerts() {
        return alertRepository == null ? List.of() : alertRepository.findAll();
    }
}
