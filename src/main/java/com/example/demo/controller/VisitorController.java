package com.example.demo.controller;

import com.example.demo.entity.VisitorEntity;
import com.example.demo.repository.VisitorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private final VisitorRepository visitorRepository;

    public VisitorController(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @PostMapping
    public VisitorEntity createVisitor(@RequestBody VisitorEntity visitor) {
        return visitorRepository.save(visitor);
    }

    @GetMapping
    public List<VisitorEntity> getAllVisitors() {
        return visitorRepository.findAll();
    }

    @GetMapping("/{id}")
    public VisitorEntity getVisitor(@PathVariable Long id) {
        return visitorRepository.findById(id).orElseThrow();
    }
}
