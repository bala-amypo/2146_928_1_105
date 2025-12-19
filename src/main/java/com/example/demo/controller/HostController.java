package com.example.demo.controller;

import com.example.demo.entity.HostEntity;
import com.example.demo.repository.HostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
public class HostController {

    private final HostRepository hostRepository;

    public HostController(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @PostMapping
    public HostEntity createHost(@RequestBody HostEntity host) {
        return hostRepository.save(host);
    }

    @GetMapping
    public List<HostEntity> getAllHosts() {
        return hostRepository.findAll();
    }

    @GetMapping("/{id}")
    public HostEntity getHost(@PathVariable Long id) {
        return hostRepository.findById(id).orElseThrow();
    }
}
