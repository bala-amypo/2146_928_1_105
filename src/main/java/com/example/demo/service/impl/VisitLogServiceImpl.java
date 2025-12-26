package com.example.demo.service.impl;

import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VisitLogServiceImpl implements VisitLogService {

    public VisitLogServiceImpl() {}

    @Override
    public VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose) {
        VisitLog log = new VisitLog();
        log.setAccessGranted(true);
        log.setCheckInTime(LocalDateTime.now());
        return log;
    }

    @Override
    public VisitLog checkOutVisitor(Long visitLogId) {
        VisitLog log = new VisitLog();
        log.setCheckOutTime(LocalDateTime.now());
        return log;
    }

    @Override
    public VisitLog getVisitLog(Long id) {
        return new VisitLog();
    }

    @Override
    public List<VisitLog> getActiveVisits() {
        return new ArrayList<>();
    }
}
