package com.api.postnet.repository;

import com.api.postnet.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Query("SELECT o From Patient  o WHERE o.dni=:patientDni")
    Patient findPatientByDni(@Param("patientDni") String patientDni);
}
