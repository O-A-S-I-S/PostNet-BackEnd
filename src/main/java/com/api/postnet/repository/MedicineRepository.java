package com.api.postnet.repository;

import com.api.postnet.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    @Query(value = "select * from medicines m join prescription_medicine pm on m.id = pm.medicine_id where pm.prescription_id =?1", nativeQuery = true)
    List<Medicine> getAllByPrescriptionAndId(Long prescriptionId);
}
