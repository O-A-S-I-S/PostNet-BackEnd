package com.api.postnet.repository;

import com.api.postnet.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription,Integer> {

    Prescription findPrescriptionById(Integer id);

    @Query(value="SELECT * FROM prescriptions p WHERE p.appointment_id=?1",nativeQuery = true)
    Prescription findPrescriptionByIdNativeSQL(Integer id);
}
