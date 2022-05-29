package com.oasis.postnet.repository;

import com.oasis.postnet.entities.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicRepository extends JpaRepository<Medic, Long> {
    @Query("select m from Medic m")
    List<Medic> getAllMedics();

    @Query(value = "select * from medics m where m.specialty = ?", nativeQuery = true)
    List<Medic> getMedicsBySpecialty(String specialty);

    Medic findMedicBySurNameAndLastName(String surName, String lastName);

}
