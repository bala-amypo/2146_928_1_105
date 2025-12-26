package com.example.demo.controller;

import com.example.demo.entity.Appointment;
import com.example.demo.service.AppointmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@Tag(name = "Appointments", description = "Appointment scheduling")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/{visitorId}/{hostId}")
    public ResponseEntity<Appointment> create(
            @PathVariable Long visitorId,
            @PathVariable Long hostId,
            @RequestBody Appointment appointment
    ) {
        return new ResponseEntity<>(
                appointmentService.createAppointment(visitorId, hostId, appointment),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public Appointment getById(@PathVariable Long id) {
        return appointmentService.getAppointment(id);
    }

    @GetMapping("/host/{hostId}")
    public List<Appointment> getForHost(@PathVariable Long hostId) {
        return appointmentService.getAppointmentsForHost(hostId);
    }

    @GetMapping("/visitor/{visitorId}")
    public List<Appointment> getForVisitor(@PathVariable Long visitorId) {
        return appointmentService.getAppointmentsForVisitor(visitorId);
    }
}

