package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Doctor;
import com.examly.springapp.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

   @PostMapping
public ResponseEntity<Doctor> createDoctor(@RequestBody(required = false) Doctor doctor) {

    
    if (doctor == null) {
        return ResponseEntity.badRequest().build();
    }

    Doctor savedDoctor = doctorService.saveDoctor(doctor);
    return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
}

    // Get All Doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        if (doctors.isEmpty()||doctors==null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doctor);
    }

    // Day 9 – Pagination
    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<Doctor>> getDoctorsPage(
            @PathVariable int page,
            @PathVariable int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Doctor> doctorPage = doctorService.getAllDoctors(pageable);

        return ResponseEntity.ok(doctorPage);
    }

    // Day 10 – Update Doctor
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(
            @PathVariable Long id,
            @RequestBody Doctor doctor) {

        Doctor updatedDoctor = doctorService.updateDoctor(id, doctor);
        if (updatedDoctor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDoctor);
    }
   // Delete Doctor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok().build();
    }
}