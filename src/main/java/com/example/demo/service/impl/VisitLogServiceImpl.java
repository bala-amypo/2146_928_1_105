package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import java.time.LocalDateTime;
import java.util.*;

public class VisitLogServiceImpl {

    private VisitLogRepository visitLogRepository;
    private VisitorRepository visitorRepository;
    private HostRepository hostRepository;

    public VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose) {
        Visitor v = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));
        Host h = hostRepository.findById(hostId)
                .orElseThrow(() -> new RuntimeException("Host not found"));

        VisitLog log = new VisitLog();
        log.setVisitor(v);
        log.setHost(h);
        log.setCheckInTime(LocalDateTime.now());
        log.setAccessGranted(true);

        return visitLogRepository.save(log);
    }

    public VisitLog checkOutVisitor(Long id) {
        VisitLog log = visitLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));

        if (log.getCheckInTime() == null) {
            throw new IllegalStateException("Visitor not checked in");
        }

        log.setCheckOutTime(LocalDateTime.now());
        return visitLogRepository.save(log);
    }

    public VisitLog getVisitLog(Long id) {
        return visitLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));
    }

    public List<VisitLog> getActiveVisits() {
        return visitLogRepository.findByCheckOutTimeIsNull();
    }
}
