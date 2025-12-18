package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private VisitorEntity visitor;

    @ManyToOne
    private HostEntity host;

    private LocalDate appointmentDate;
    private String purpose;
    private String status = "SCHEDULED";

    public Long getId() {
        return id;
    }

    public VisitorEntity getVisitor() {
        return visitor;
    }

    public HostEntity getHost() {
        return host;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }
}
