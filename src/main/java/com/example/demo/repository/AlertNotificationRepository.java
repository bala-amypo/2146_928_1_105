package com.example.demo.repository;

import com.example.demo.model.AlertNotification;
import java.util.*;

public interface AlertNotificationRepository {
    AlertNotification save(AlertNotification a);
    Optional<AlertNotification> findById(Long id);
    Optional<AlertNotification> findByVisitLogId(Long visitLogId);
    List<AlertNotification> findAll();
}
