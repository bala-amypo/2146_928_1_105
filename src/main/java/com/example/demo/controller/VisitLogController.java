package com.example.demo.controller;

import com.example.demo.dto.CheckInRequest;
import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
@Tag(name = "Visit Logs", description = "Visitor check-in and check-out APIs")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping("/checkin/{visitorId}/{hostId}")
    public ResponseEntity<VisitLog> checkInVisitor(
            @PathVariable Long visitorId,
            @PathVariable Long hostId,
            @Valid @RequestBody CheckInRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(visitLogService.checkInVisitor(visitorId, hostId, request.getPurpose()));
    }

    @PostMapping("/checkout/{visitLogId}")
    public ResponseEntity<VisitLog> checkOutVisitor(@PathVariable Long visitLogId) {
        return ResponseEntity.ok(visitLogService.checkOutVisitor(visitLogId));
    }

    @GetMapping("/active")
    public ResponseEntity<List<VisitLog>> getActiveVisits() {
        return ResponseEntity.ok(visitLogService.getActiveVisits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitLog> getVisitLog(@PathVariable Long id) {
        return ResponseEntity.ok(visitLogService.getVisitLog(id));
    }
}
