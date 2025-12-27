package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Doctor;
import com.examly.springapp.repository.DoctorRepository;
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Page<Doctor> getAllDoctors(Pageable pageable) {
        return doctorRepository.findAll(pageable);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
public Doctor updateDoctor(Long id, Doctor doctor) {
    Doctor existingDoctor = doctorRepository.findById(id).orElse(null);

    if (existingDoctor == null) {
        return null;
    }

    if (doctor.getName() != null) {
        existingDoctor.setName(doctor.getName());
    }
    if (doctor.getSpecialization() != null) {
        existingDoctor.setSpecialization(doctor.getSpecialization());
    }
    if (doctor.getEmail() != null) {
        existingDoctor.setEmail(doctor.getEmail());
    }
    if (doctor.getPhone() != null) {
        existingDoctor.setPhone(doctor.getPhone());
    }
    if (doctor.getRoomNumber() != null) {
        existingDoctor.setRoomNumber(doctor.getRoomNumber());
    }

    return existingDoctor;
}


    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
