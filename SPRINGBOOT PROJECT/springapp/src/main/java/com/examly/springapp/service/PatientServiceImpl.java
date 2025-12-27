package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Patient;
import com.examly.springapp.repository.PatientRepository;
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }
    @Override
    public Patient updatePatient(Patient patient, Long patientId) {
    Patient existing = patientRepository.findById(patientId).orElse(null);
    if (existing == null) return null;

    if (patient.getName() != null) {
        existing.setName(patient.getName());
    }
    if (patient.getEmail() != null) {
        existing.setEmail(patient.getEmail());
    }
    if (patient.getPhone() != null) {
        existing.setPhone(patient.getPhone());
    }
    if (patient.getAddress() != null) {
        existing.setAddress(patient.getAddress());
    }
    if (patient.getAge() != null) {
        existing.setAge(patient.getAge());
    }

    return patientRepository.save(existing);
}



   

}
