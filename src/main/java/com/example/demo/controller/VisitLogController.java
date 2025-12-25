package com.example.demo.controller;

import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    /**
     * CHECK-IN VISITOR
     * Request body is plain String (purpose)
     */
    @PostMapping("/checkin/{visitorId}/{hostId}")
    public ResponseEntity<VisitLog> checkInVisitor(
            @PathVariable Long visitorId,
            @PathVariable Long hostId,
            @RequestBody String purpose) {

        VisitLog visitLog = visitLogService.checkInVisitor(visitorId, hostId, purpose);
        return new ResponseEntity<>(visitLog, HttpStatus.CREATED);
    }

    /**
     * CHECK-OUT VISITOR
     */
    @PostMapping("/checkout/{visitLogId}")
    public ResponseEntity<VisitLog> checkOutVisitor(@PathVariable Long visitLogId) {
        return ResponseEntity.ok(visitLogService.checkOutVisitor(visitLogId));
    }

    /**
     * GET ALL ACTIVE VISITS
     */
    @GetMapping("/active")
    public ResponseEntity<List<VisitLog>> getActiveVisits() {
        return ResponseEntity.ok(visitLogService.getActiveVisits());
    }

    /**
     * GET VISIT BY ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<VisitLog> getVisitLog(@PathVariable Long id) {
        return ResponseEntity.ok(visitLogService.getVisitLog(id));
    }
}
