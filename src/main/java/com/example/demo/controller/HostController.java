package com.example.demo.controller;

import com.example.demo.model.Host;
import com.example.demo.service.HostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
@Tag(name = "Hosts", description = "Host management APIs")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping
    public ResponseEntity<Host> createHost(@Valid @RequestBody Host host) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(hostService.createHost(host));
    }

    @GetMapping
    public ResponseEntity<List<Host>> getAllHosts() {
        return ResponseEntity.ok(hostService.getAllHosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Host> getHost(@PathVariable Long id) {
        return ResponseEntity.ok(hostService.getHost(id));
    }
}
