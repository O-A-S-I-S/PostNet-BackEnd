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

    @Query(value = "select * from patients p where p.surname like '%'+?1+'%' or p.last_name like '%'+?2+'%'", nativeQuery = true)
    Page<Patient> getPatientsBySurnameContainingOrLastNameContaining(String surname, String lastName, Pageable pageable);

    @Query(value = "select * from patients p where p.blood_type = ?1", nativeQuery = true)
    Page<Patient> getPatientsByBloodType(String bloodType, Pageable pageable);

    @Query(value = "select * from patients p where p.dni = ?1", nativeQuery = true)
    Patient findPatientByDni(String dni);

    @Query(value = "select * from patients p where p.dni = ?1", nativeQuery = true)
    List<Patient> findPatientsByDni(String dni);

    @Query(value = "select * from patients p where p.dni = ?1 and p.password=?2", nativeQuery = true)
    Patient findPatientByDniAndPassword(String dni, String password);

    @Query(value = "select * from patients p where p.dni = ?1 and p.password=?2", nativeQuery = true)
    List<Patient> findPatientsByDniAndPassword(String dni, String password);
}
