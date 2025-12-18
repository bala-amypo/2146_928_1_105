package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.AlertNotificationEntity;

public interface AlertNotificationRepository extends JpaRepository<AlertNotificationEntity, Long> {
    AlertNotificationEntity findByVisitLogId(Long id);
}
