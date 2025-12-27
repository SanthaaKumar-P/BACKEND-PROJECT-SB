package com.examly.springapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long recordId;

    private String diagnosis;
    private String prescription;
    @JsonProperty
     @Column(name = "patient_id")
    private Long patientId;

   
    public MedicalRecord() {}
    

    public MedicalRecord(String diagnosis, String prescription, Long patientId) {
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.patientId = patientId;
    }


    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
    @JsonProperty("patientId")
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
