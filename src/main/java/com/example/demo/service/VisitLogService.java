package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.VisitLogEntity;

public interface VisitLogService {
    VisitLogEntity checkInVisitor(Long visitorId, Long hostId, String purpose);
    VisitLogEntity checkOutVisitor(Long visitLogId);
    List<VisitLogEntity> getActiveVisits();
    VisitLogEntity getVisitLog(Long id);
}
