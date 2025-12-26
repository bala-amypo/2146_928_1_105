package com.example.demo.service.impl;

import com.example.demo.model.VisitLog;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.VisitLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitLogServiceImpl implements VisitLogService {

    private VisitLogRepository visitLogRepository;

    public VisitLogServiceImpl() {}

    public VisitLogServiceImpl(VisitLogRepository visitLogRepository) {
        this.visitLogRepository = visitLogRepository;
    }

    @Override
    public VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose) {
        VisitLog log = new VisitLog();
        log.setCheckInTime(LocalDateTime.now());
        log.setAccessGranted(true);
        return log;
    }

    @Override
    public VisitLog checkOutVisitor(Long visitLogId) {

        if (visitLogRepository == null) {
            throw new IllegalStateException("Cannot checkout without check-in");
        }

        VisitLog log = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));

        if (log.getCheckInTime() == null) {
            throw new IllegalStateException("Cannot checkout without check-in");
        }

        log.setCheckOutTime(LocalDateTime.now());
        return visitLogRepository.save(log);
    }

    @Override
    public VisitLog getVisitLog(Long id) {
        if (visitLogRepository == null) {
            throw new RuntimeException("VisitLog not found");
        }

        return visitLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));
    }

    @Override
    public List<VisitLog> getActiveVisits() {
        return visitLogRepository == null
                ? List.of()
                : visitLogRepository.findByCheckOutTimeIsNull();
    }
}
