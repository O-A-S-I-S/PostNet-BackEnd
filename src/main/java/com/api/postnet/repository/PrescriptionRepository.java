package com.api.postnet.repository;

import com.api.postnet.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

    Prescription findPrescriptionById(Integer id);

    @Query(value="SELECT * FROM prescriptions p WHERE p.appointment_id=?1",nativeQuery = true)
    Prescription findPrescriptionByIdNativeSQL(Long id);

    //@Query(value="SELECT * FROM patients p join appointments a on p.id=a.patient_id join  prescriptions pp on a.id=?1",nativeQuery = true)
    @Query(value = "SELECT * FROM prescriptions pp join appointments a on pp.appointment_id=a.id join patients p on a.patient_id=?1",nativeQuery = true)
    List<Prescription> findPrescriptionsByPatientId(Long id);
}
