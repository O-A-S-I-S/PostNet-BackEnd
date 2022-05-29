package com.api.postnet.repository;

import com.api.postnet.entities.Appoiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppoimentRepository extends JpaRepository<Appoiment,Long> {
    @Query("SELECT o From Appoiment  o WHERE o.patient.id=:patientId")
    List<Appoiment> findAppointmentByPatientId(@Param("patientId") Long patientId);

    @Query("SELECT o From Appoiment o WHERE o.id=:appoimentId")
    Appoiment findAppoimentByAppoimentId(@Param("appoimentId") Long appoimentId);

//    Appoiment findAppoimentById(String id);
//    List<Appoiment> findAppoimentsByPatientId(Long patient_id);
//
//    @Query(value="SELECT * from Appoiment o WHERE o.id=?1",nativeQuery = true)
//    Appoiment findAppoimentByAppointmentIdSQLNative(String appointment_id);
//
//    @Query(value="SELECT * from Appoiment o WHERE o.patient_id=?1",nativeQuery = true)
//    Appoiment findAppoimentByPatientIdSQLNative(Long patient_id);
}
