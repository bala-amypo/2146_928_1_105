package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.entity.VisitorEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.VisitorService;

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public VisitorEntity createVisitor(VisitorEntity visitor) {
        return visitorRepository.save(visitor);
    }

    public VisitorEntity getVisitor(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
    }

    public List<VisitorEntity> getAllVisitors() {
        return visitorRepository.findAll();
    }
}
