package com.example.demo.controller;

import com.example.demo.entity.AppointmentEntity;
import com.example.demo.repository.AppointmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping
    public List<AppointmentEntity> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @PostMapping
    public AppointmentEntity createAppointment(@RequestBody AppointmentEntity appointment) {
        return appointmentRepository.save(appointment);
    }
}
