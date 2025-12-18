package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AppointmentEntity;

public interface AppointmentService {
    AppointmentEntity createAppointment(Long visitorId, Long hostId, AppointmentEntity appointment);
    AppointmentEntity getAppointment(Long id);
    List<AppointmentEntity> getAppointmentsForHost(Long hostId);
    List<AppointmentEntity> getAppointmentsForVisitor(Long visitorId);
}
