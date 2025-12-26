package com.example.demo.controller;

import com.example.demo.model.Host;
import com.example.demo.service.HostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
@Tag(name = "Hosts", description = "Host management endpoints")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping
    public ResponseEntity<Host> create(@RequestBody Host host) {
        return new ResponseEntity<>(hostService.createHost(host), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Host> getAll() {
        return hostService.getAllHosts();
    }

    @GetMapping("/{id}")
    public Host getById(@PathVariable Long id) {
        return hostService.getHost(id);
    }
}
