package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.VisitorEntity;

public interface VisitorService {
    VisitorEntity createVisitor(VisitorEntity visitor);
    VisitorEntity getVisitor(Long id);
    List<VisitorEntity> getAllVisitors();
}
