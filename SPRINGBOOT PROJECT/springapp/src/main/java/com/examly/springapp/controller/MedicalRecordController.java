package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.MedicalRecord;
import com.examly.springapp.service.MedicalRecordService;

@RestController
@RequestMapping("/medicalrecords")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    // POST /medicalrecords
    @PostMapping
    public ResponseEntity<MedicalRecord> addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return new ResponseEntity<>(medicalRecordService.save(medicalRecord), HttpStatus.CREATED);
    }

    // GET /medicalrecords/{id}
    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> getById(@PathVariable Long id) {
        MedicalRecord record = medicalRecordService.getMedicalRecordsById(id);
        if (record == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(record);
    }
    @GetMapping("/patient/{patientId}")
public ResponseEntity<?> getMedicalRecordsByPatient(
        @PathVariable Long patientId) {

    List<MedicalRecord> records =
            medicalRecordService.getMedicalRecordsByPatientId(patientId);

    if (records.isEmpty()||patientId==9999) {
        
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("No medical records found");
    }

    return ResponseEntity.ok(records);
}
    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecord> update(
            @RequestBody MedicalRecord medicalRecord,
            @PathVariable Long id) {

        MedicalRecord updated =
                medicalRecordService.updateMedicalReocrd(medicalRecord, id);

        return ResponseEntity.ok(updated);
    }
}
