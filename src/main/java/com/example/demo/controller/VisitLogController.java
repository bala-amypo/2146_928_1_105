package com.example.demo.controller;

import com.example.demo.entity.VisitLogEntity;
import com.example.demo.repository.VisitLogRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visit-logs")
public class VisitLogController {

    private final VisitLogRepository visitLogRepository;

    public VisitLogController(VisitLogRepository visitLogRepository) {
        this.visitLogRepository = visitLogRepository;
    }

    @GetMapping
    public List<VisitLogEntity> getAllVisitLogs() {
        return visitLogRepository.findAll();
    }

    @GetMapping("/{id}")
    public VisitLogEntity getVisitLogById(@PathVariable Long id) {
        return visitLogRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public VisitLogEntity createVisitLog(@RequestBody VisitLogEntity visitLog) {
        return visitLogRepository.save(visitLog);
    }
}
