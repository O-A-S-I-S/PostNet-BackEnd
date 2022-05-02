package com.oasis.postnet.repository;

import com.oasis.postnet.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, String> {
    Patient findPatientByDni(String dni);

    @Query(value = "select * from patients", nativeQuery = true)
    List<Patient> getAllPatients();
}
