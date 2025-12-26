package com.example.demo.controller;

import com.example.demo.entity.VisitLog;
import com.example.demo.service.VisitLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
@Tag(name = "Visit Logs", description = "Check-in and check-out")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping("/checkin/{visitorId}/{hostId}")
    public ResponseEntity<VisitLog> checkIn(
            @PathVariable Long visitorId,
            @PathVariable Long hostId,
            @RequestBody String purpose
    ) {
        return new ResponseEntity<>(
                visitLogService.checkInVisitor(visitorId, hostId, purpose),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/checkout/{visitLogId}")
    public VisitLog checkOut(@PathVariable Long visitLogId) {
        return visitLogService.checkOutVisitor(visitLogId);
    }

    @GetMapping("/active")
    public List<VisitLog> getActive() {
        return visitLogService.getActiveVisits();
    }

    @GetMapping("/{id}")
    public VisitLog getById(@PathVariable Long id) {
        return visitLogService.getVisitLog(id);
    }
}
