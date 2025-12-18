package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.demo.entity.HostEntity;

public interface HostRepository extends JpaRepository<HostEntity, Long> {
    Optional<HostEntity> findByEmail(String email);
}
