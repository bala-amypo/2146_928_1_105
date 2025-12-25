package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.VisitLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitLogServiceImpl implements VisitLogService {

    private VisitLogRepository visitLogRepository;
    private VisitorRepository visitorRepository;
    private HostRepository hostRepository;

    // ✅ No-arg constructor for tests
    public VisitLogServiceImpl() {
    }

    // ✅ Constructor for Spring
    public VisitLogServiceImpl(VisitLogRepository visitLogRepository,
                               VisitorRepository visitorRepository,
                               HostRepository hostRepository) {
        this.visitLogRepository = visitLogRepository;
        this.visitorRepository = visitorRepository;
        this.hostRepository = hostRepository;
    }

    @Override
    public VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose) {

        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

        Host host = hostRepository.findById(hostId)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found"));

        VisitLog log = new VisitLog();
        log.setVisitor(visitor);
        log.setHost(host);
        log.setPurpose(purpose);
        log.setAccessGranted(true);
        log.setAlertSent(false);
        log.setCheckInTime(LocalDateTime.now());

        return visitLogRepository.save(log);
    }

    @Override
    public VisitLog checkOutVisitor(Long visitLogId) {

        VisitLog log = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));

        log.setCheckOutTime(LocalDateTime.now());
        return visitLogRepository.save(log);
    }

    @Override
    public List<VisitLog> getActiveVisits() {
        return visitLogRepository.findByCheckOutTimeIsNull();
    }

    @Override
    public VisitLog getVisitLog(Long id) {
        return visitLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));
    }
}
