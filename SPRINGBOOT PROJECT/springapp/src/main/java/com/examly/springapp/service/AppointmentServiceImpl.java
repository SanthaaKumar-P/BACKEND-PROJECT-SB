package com.examly.springapp.service;

import com.examly.springapp.model.Appointment;

import com.examly.springapp.repository.AppointmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment); // ✅ SIMPLE SAVE
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public Appointment updateAppointments(Appointment appointment, Long id) {
        Appointment existing = appointmentRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setDoctorId(appointment.getDoctorId());
        existing.setPatientId(appointment.getPatientId());
        existing.setAppointmentTime(appointment.getAppointmentTime());
        existing.setStatus(appointment.getStatus());
        existing.setNotes(appointment.getNotes());

        return appointmentRepository.save(existing);
    }

    @Override
    public List<Appointment> getAppointmentsByStatus(String status) {
        return appointmentRepository.findByStatus(status);
    }
}

