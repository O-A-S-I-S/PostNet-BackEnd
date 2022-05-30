package com.api.postnet.repository;

import com.api.postnet.entities.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicRepository extends JpaRepository<Medic, Long> {
    @Query("select m from Medic m")
    List<Medic> getAllMedics();

    @Query(value = "select * from medics m join specialties s on m.specialty_id = s.id where s.name = ?", nativeQuery = true)
    List<Medic> getMedicsBySpecialty(String specialty);

    Medic findMedicBySurnameAndLastName(String surName, String lastName);

    //JPQL
    @Query("select m from Medic m where m.dni= ?1")
    Medic findMedicByDni(String medicId);

    Medic findMedicByDniAndPassword(String dni, String password);
}
