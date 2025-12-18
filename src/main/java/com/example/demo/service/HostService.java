package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.HostEntity;

public interface HostService {
    HostEntity createHost(HostEntity host);
    HostEntity getHost(Long id);
    List<HostEntity> getAllHosts();
}
