package com.example.demo.service.impl;

import com.example.demo.entity.Host;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HostRepository;
import com.example.demo.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements HostService {

    private HostRepository hostRepository;

    // No-args constructor for test compatibility
    public HostServiceImpl() {
    }

    // Constructor for normal dependency injection
    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public Host createHost(Host host) {
        if (hostRepository == null) {
            throw new IllegalStateException("HostRepository not initialized");
        }
        return hostRepository.save(host);
    }

    @Override
    public Host getHost(Long id) {
        if (hostRepository == null) {
            throw new IllegalStateException("HostRepository not initialized");
        }
        return hostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found"));
    }

    @Override
    public Host getHostByEmail(String email) {
        if (hostRepository == null) {
            throw new IllegalStateException("HostRepository not initialized");
        }
        return hostRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found"));
    }

    @Override
    public List<Host> getAllHosts() {
        if (hostRepository == null) {
            throw new IllegalStateException("HostRepository not initialized");
        }
        return hostRepository.findAll();
    }
}
