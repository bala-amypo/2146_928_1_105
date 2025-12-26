package com.example.demo.service.impl;

import com.example.demo.model.AlertNotification;
import com.example.demo.service.AlertNotificationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    public AlertNotificationServiceImpl() {}

    @Override
    public AlertNotification sendAlert(Long visitLogId) {
        AlertNotification alert = new AlertNotification();
        alert.setAlertMessage("Visitor arrived");
        alert.setSentAt(LocalDateTime.now());
        return alert;
    }

    @Override
    public AlertNotification getAlert(Long id) {
        return new AlertNotification();
    }

    @Override
    public List<AlertNotification> getAllAlerts() {
        return new ArrayList<>();
    }
}
