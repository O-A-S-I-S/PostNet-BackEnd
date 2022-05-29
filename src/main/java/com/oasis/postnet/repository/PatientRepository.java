package com.oasis.postnet.repository;

import com.oasis.postnet.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query(value = "select * from patients", nativeQuery = true)
    List<Patient> getAllPatients();

    @Query(value = "select * from patients p where p.blood_type = ?", nativeQuery = true)
    List<Patient> getPatientsByBloodType(String bloodType);
}
