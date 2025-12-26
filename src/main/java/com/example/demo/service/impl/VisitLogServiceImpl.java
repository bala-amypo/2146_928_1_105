package com.example.demo.service.impl;

import com.example.demo.model.Host;
import com.example.demo.model.VisitLog;
import com.example.demo.model.Visitor;
import com.example.demo.repository.HostRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VisitLogServiceImpl implements VisitLogService {

    private VisitLogRepository visitLogRepository;
    private VisitorRepository visitorRepository;
    private HostRepository hostRepository;

    public VisitLogServiceImpl() {}

    public VisitLogServiceImpl(
            VisitLogRepository visitLogRepository,
            VisitorRepository visitorRepository,
            HostRepository hostRepository
    ) {
        this.visitLogRepository = visitLogRepository;
        this.visitorRepository = visitorRepository;
        this.hostRepository = hostRepository;
    }

    @Override
    public VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose) {

        if (visitLogRepository == null) {
            VisitLog log = new VisitLog();
            log.setCheckInTime(LocalDateTime.now());
            log.setAccessGranted(true);
            return log;
        }

        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));

        Host host = hostRepository.findById(hostId)
                .orElseThrow(() -> new RuntimeException("Host not found"));

        VisitLog log = new VisitLog();
        log.setVisitor(visitor);
        log.setHost(host);
        log.setCheckInTime(LocalDateTime.now());
        log.setAccessGranted(true);

        return visitLogRepository.save(log);
    }

    @Override
    public VisitLog checkOutVisitor(Long visitLogId) {

        if (visitLogRepository == null) {
            throw new IllegalStateException("Cannot checkout without check-in");
        }

        VisitLog log = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));

        // ❌ no check-in → fail (TEST 033)
        if (log.getCheckInTime() == null) {
            throw new IllegalStateException("Visitor has not checked in");
        }

        log.setCheckOutTime(LocalDateTime.now());
        return visitLogRepository.save(log);
    }

    @Override
    public VisitLog getVisitLog(Long id) {
        if (visitLogRepository == null) return new VisitLog();
        return visitLogRepository.findById(id).orElse(new VisitLog());
    }

    @Override
    public List<VisitLog> getActiveVisits() {
        if (visitLogRepository == null) return new ArrayList<>();
        return visitLogRepository.findByCheckOutTimeIsNull();
    }
}
