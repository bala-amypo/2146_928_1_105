package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.entity.VisitorEntity;
import com.example.demo.service.VisitorService;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public VisitorEntity create(@RequestBody VisitorEntity visitor) {
        return visitorService.createVisitor(visitor);
    }

    @GetMapping
    public List<VisitorEntity> getAll() {
        return visitorService.getAllVisitors();
    }

    @GetMapping("/{id}")
    public VisitorEntity get(@PathVariable Long id) {
        return visitorService.getVisitor(id);
    }
}
