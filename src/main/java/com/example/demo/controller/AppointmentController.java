package com.example.demo.controller;

import com.example.demo.model.Appointment;
import com.example.demo.service.AppointmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@Tag(name = "Appointments", description = "Appointment scheduling APIs")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/{visitorId}/{hostId}")
    public ResponseEntity<Appointment> createAppointment(
            @PathVariable Long visitorId,
            @PathVariable Long hostId,
            @Valid @RequestBody Appointment appointment) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(appointmentService.createAppointment(visitorId, hostId, appointment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointment(id));
    }

    @GetMapping("/host/{hostId}")
    public ResponseEntity<List<Appointment>> getAppointmentsForHost(@PathVariable Long hostId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsForHost(hostId));
    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<Appointment>> getAppointmentsForVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsForVisitor(visitorId));
    }
}
