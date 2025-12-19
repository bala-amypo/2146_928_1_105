package com.example.demo.controller;

import com.example.demo.entity.HostEntity;
import com.example.demo.entity.VisitLogEntity;
import com.example.demo.entity.VisitorEntity;
import com.example.demo.repository.HostRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.repository.VisitorRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitLogController {

    private final VisitLogRepository visitLogRepository;
    private final VisitorRepository visitorRepository;
    private final HostRepository hostRepository;

    public VisitLogController(
            VisitLogRepository visitLogRepository,
            VisitorRepository visitorRepository,
            HostRepository hostRepository) {
        this.visitLogRepository = visitLogRepository;
        this.visitorRepository = visitorRepository;
        this.hostRepository = hostRepository;
    }

    @PostMapping("/checkin/{visitorId}/{hostId}")
    public VisitLogEntity checkIn(
            @PathVariable Long visitorId,
            @PathVariable Long hostId) {

        VisitorEntity visitor = visitorRepository.findById(visitorId).orElseThrow();
        HostEntity host = hostRepository.findById(hostId).orElseThrow();

        VisitLogEntity visit = new VisitLogEntity();
        visit.setVisitor(visitor);
        visit.setHost(host);
        visit.setCheckInTime(LocalDateTime.now());
        visit.setAccessGranted(true);

        return visitLogRepository.save(visit);
    }

    @PostMapping("/checkout/{visitLogId}")
    public VisitLogEntity checkOut(@PathVariable Long visitLogId) {

        VisitLogEntity visit = visitLogRepository.findById(visitLogId).orElseThrow();
        visit.setCheckOutTime(LocalDateTime.now());

        return visitLogRepository.save(visit);
    }

    @GetMapping("/{id}")
    public VisitLogEntity getVisit(@PathVariable Long id) {
        return visitLogRepository.findById(id).orElseThrow();
    }
}
