package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AlertNotificationEntity;

public interface AlertNotificationService {
    AlertNotificationEntity sendAlert(Long visitLogId);
    AlertNotificationEntity getAlert(Long id);
    List<AlertNotificationEntity> getAllAlerts();
}
