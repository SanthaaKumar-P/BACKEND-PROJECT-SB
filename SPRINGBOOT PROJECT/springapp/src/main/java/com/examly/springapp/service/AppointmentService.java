package com.examly.springapp.service;

import com.examly.springapp.model.Appointment;

import java.util.List;


public interface AppointmentService {

    Appointment save(Appointment appointment);

    Appointment getAppointmentById(Long id);

    Appointment updateAppointments(Appointment appointment, Long id);

    List<Appointment> getAppointmentsByStatus(String status);
}
