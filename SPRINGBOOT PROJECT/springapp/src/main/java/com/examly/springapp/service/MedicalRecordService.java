package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.MedicalRecord;

public interface MedicalRecordService {

    MedicalRecord save(MedicalRecord medicalRecord);

    MedicalRecord getMedicalRecordsById(Long recordId);

    MedicalRecord updateMedicalReocrd(MedicalRecord medicalRecord, Long recordId);

    List<MedicalRecord> getMedicalRecordsByPatientId(Long patientId); // 🔴 REQUIRED

    
}
