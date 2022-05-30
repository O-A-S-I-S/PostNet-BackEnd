package com.api.postnet.repository;

import com.api.postnet.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query(value = "select * from patients", nativeQuery = true)
    List<Patient> getAllPatients();

    @Query(value = "select * from patients p where p.blood_type = ?1", nativeQuery = true)
    List<Patient> getPatientsByBloodType(String bloodType);

    Patient findPatientByDni(String dni);

    List<Patient> findPatientsByDni(String dni);

    Patient findPatientByDniAndPassword(String dni, String password);

    List<Patient> findPatientsByDniAndPassword(String dni, String password);
}
