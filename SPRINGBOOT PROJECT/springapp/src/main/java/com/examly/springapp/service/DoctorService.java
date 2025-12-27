package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.examly.springapp.model.Doctor;

public interface DoctorService {
     
    Page<Doctor> getAllDoctors(Pageable pageable);

    Doctor saveDoctor(Doctor doctor);

    Doctor updateDoctor(Long id, Doctor doctor);

    void deleteDoctor(Long id);

    List<Doctor> getAllDoctors();

    Doctor getDoctorById(Long doctorId);
}

