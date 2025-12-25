package com.example.demo.service.impl;

import com.example.demo.model.Host;
import com.example.demo.repository.HostRepository;

public class HostServiceImpl {

    private HostRepository hostRepository;

    public Host createHost(Host h) {
        return hostRepository.save(h);
    }

    public Host getHost(Long id) {
        return hostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Host not found"));
    }
}
