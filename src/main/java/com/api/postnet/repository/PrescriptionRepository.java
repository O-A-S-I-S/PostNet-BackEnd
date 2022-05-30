package com.api.postnet.repository;

import com.api.postnet.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    @Query("select p from Prescription p where p.appoiment.id =:appoinmentId")
    List<Prescription> findPrescriptionsByAppoimentId(@Param("appoinmentId") Long appoinmentId);
}
