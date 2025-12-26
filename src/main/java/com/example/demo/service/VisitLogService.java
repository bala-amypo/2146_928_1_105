package com.example.demo.service;

import com.example.demo.model.VisitLog;

import java.util.List;

public interface VisitLogService {

    VisitLog checkIn(Long visitorId, Long hostId);

    VisitLog checkOut(Long visitLogId);

    VisitLog getVisitLog(Long id);

    List<VisitLog> getActiveVisits();
}
