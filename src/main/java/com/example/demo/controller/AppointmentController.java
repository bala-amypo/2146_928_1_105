package com.example.demo.controller;

import com.example.demo.entity.AppointmentEntity;
import com.example.demo.entity.HostEntity;
import com.example.demo.entity.VisitorEntity;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.HostRepository;
import com.example.demo.repository.VisitorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private final VisitorRepository visitorRepository;
    private final HostRepository hostRepository;

    public AppointmentController(
            AppointmentRepository appointmentRepository,
            VisitorRepository visitorRepository,
            HostRepository hostRepository) {
        this.appointmentRepository = appointmentRepository;
        this.visitorRepository = visitorRepository;
        this.hostRepository = hostRepository;
    }

    @PostMapping("/{visitorId}/{hostId}")
    public AppointmentEntity createAppointment(
            @PathVariable Long visitorId,
            @PathVariable Long hostId) {

        VisitorEntity visitor = visitorRepository.findById(visitorId).orElseThrow();
        HostEntity host = hostRepository.findById(hostId).orElseThrow();

        AppointmentEntity appointment = new AppointmentEntity();
        appointment.setVisitor(visitor);
        appointment.setHost(host);
        appointment.setStatus("SCHEDULED");

        return appointmentRepository.save(appointment);
    }

    @GetMapping("/host/{hostId}")
    public List<AppointmentEntity> getByHost(@PathVariable Long hostId) {
        return appointmentRepository.findByHostId(hostId);
    }

    @GetMapping("/visitor/{visitorId}")
    public List<AppointmentEntity> getByVisitor(@PathVariable Long visitorId) {
        return appointmentRepository.findByVisitorId(visitorId);
    }

    @GetMapping("/{id}")
    public AppointmentEntity getAppointment(@PathVariable Long id) {
        return appointmentRepository.findById(id).orElseThrow();
    }
}
