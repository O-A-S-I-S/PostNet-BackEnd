package com.oasis.postnet.repository;

import com.oasis.postnet.entities.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicRepository extends JpaRepository<Medic, String> {
    //JPQL
    @Query("select m from Medic m where m.dni= ?1")
    Medic findMedicByDni(String medicId);

    @Query("select m from Medic m")
    List<Medic> getAllMedics();

    Medic findMedicBySurNameAndLastName(String surName, String lastName);

    //SQL
    //@Query(value = "select * from medics m where m.person_dni= ?", nativeQuery = true)

}
