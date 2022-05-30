package com.api.postnet.repository;

import com.api.postnet.entities.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicRepository extends JpaRepository<Medic,Long> {

    @Query("SELECT o From Medic  o WHERE o.dni=:medicDni")
    Medic findMedicByDni(@Param("medicDni") String medicDni);

<<<<<<< HEAD
=======
    @Query(value = "select * from medics m join specialties s on m.specialty_id = s.id where s.name = ?1", nativeQuery = true)
    List<Medic> getMedicsBySpecialty(String specialty);

    Medic findMedicBySurnameAndLastName(String surName, String lastName);

    //JPQL
    @Query("select m from Medic m where m.dni= ?1")
    Medic findMedicByDni(String medicId);

    Medic findMedicByDniAndPassword(String dni, String password);
>>>>>>> parent of 3c81fa9 (fixed errors with patient sign in and blood type)
}
