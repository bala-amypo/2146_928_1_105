package com.example.demo.repository;

import com.example.demo.model.VisitLog;
import java.util.*;

public interface VisitLogRepository {
    VisitLog save(VisitLog v);
    Optional<VisitLog> findById(Long id);
    List<VisitLog> findByCheckOutTimeIsNull();
}
