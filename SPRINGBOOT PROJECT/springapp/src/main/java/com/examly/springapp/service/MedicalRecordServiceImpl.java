package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Appointment;
import com.examly.springapp.model.MedicalRecord;
import com.examly.springapp.repository.AppointmentRepository;
import com.examly.springapp.repository.MedicalRecordRepository;
@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Override
    public MedicalRecord save(MedicalRecord record) {
        return medicalRecordRepository.save(record);
    }

    @Override
    public MedicalRecord getMedicalRecordsById(Long id) {
        return medicalRecordRepository.findById(id).orElse(null);
    }

    @Override
    public List<MedicalRecord> getMedicalRecordsByPatientId(Long patientId) {
        return medicalRecordRepository.findByPatientId(patientId);
    }

    @Override
    public MedicalRecord updateMedicalReocrd(MedicalRecord record, Long id) {
        MedicalRecord existing =
                medicalRecordRepository.findById(id).orElse(null);

        if (existing == null) return null;

        existing.setDiagnosis(record.getDiagnosis());
        existing.setPrescription(record.getPrescription());

        return medicalRecordRepository.save(existing);
    }
}

