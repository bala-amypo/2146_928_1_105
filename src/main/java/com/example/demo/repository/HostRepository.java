package com.example.demo.repository;

import com.example.demo.model.Host;
import java.util.*;

public interface HostRepository {
    Host save(Host h);
    Optional<Host> findById(Long id);
    Optional<Host> findByEmail(String email);
}
