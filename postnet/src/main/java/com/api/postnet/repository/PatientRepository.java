package com.api.postnet.repository;

import com.api.postnet.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query(value = "select * from patients", nativeQuery = true)
    Page<Patient> getAllPatients(Pageable pageable);

    Page<Patient> getPatientsBySurnameContainingOrLastNameContaining(String surname, String lastName, Pageable pageable);

    @Query(value = "select * from patients p where p.blood_type = ?1", nativeQuery = true)
    Page<Patient> getPatientsByBloodType(String bloodType, Pageable pageable);

    Patient findPatientByDni(String dni);

    List<Patient> findPatientsByDni(String dni);

    Patient findPatientByDniAndPassword(String dni, String password);

    List<Patient> findPatientsByDniAndPassword(String dni, String password);
}
