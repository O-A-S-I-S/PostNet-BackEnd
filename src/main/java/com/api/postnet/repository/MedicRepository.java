package com.api.postnet.repository;

import com.api.postnet.entities.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicRepository extends JpaRepository<Medic,Long> {

    @Query("SELECT o From Medic  o WHERE o.dni=:medicDni")
    Medic findMedicByDni(@Param("medicDni") String medicDni);

}
