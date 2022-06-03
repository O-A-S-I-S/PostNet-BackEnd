package com.api.postnet.repository;

import com.api.postnet.entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpecialityRepository extends JpaRepository<Speciality,Long> {
    @Query("SELECT o From Speciality  o WHERE o.name=:specialityName")
    Speciality findSpecialityByName(@Param("specialityName") String specialityName);
}
