package com.example.demo.controller;

import com.example.demo.entity.Visitor;
import com.example.demo.service.VisitorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
@Tag(name = "Visitors", description = "Visitor management APIs")
@CrossOrigin // ✅ REQUIRED for Swagger + proxy
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public Visitor createVisitor(@Valid @RequestBody Visitor visitor) {
        return visitorService.createVisitor(visitor);
    }

    @GetMapping
    public List<Visitor> getAllVisitors() {
        return visitorService.getAllVisitors();
    }

    @GetMapping("/{id}")
    public Visitor getVisitor(@PathVariable Long id) {
        return visitorService.getVisitor(id);
    }
}
