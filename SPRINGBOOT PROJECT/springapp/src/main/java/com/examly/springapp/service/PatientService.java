package com.examly.springapp.service;


import com.examly.springapp.model.Patient;

public interface PatientService {

    Patient save(Patient patient);

    Patient getPatientById(Long patientId);

    Patient updatePatient(Patient patient,Long patientId);
    
} 
