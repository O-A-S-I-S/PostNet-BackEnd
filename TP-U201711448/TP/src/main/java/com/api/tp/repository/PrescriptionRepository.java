package com.api.tp.repository;

import com.api.tp.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription,Integer> {
    @Query(value="SELECT * FROM prescripcion p WHERE p.appointment_id=?1",nativeQuery = true)
    Prescription findPrescriptionById(Integer id);
}
