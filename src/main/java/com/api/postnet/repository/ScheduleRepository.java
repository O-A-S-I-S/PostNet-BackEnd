package com.api.postnet.repository;


import com.api.postnet.entities.Appoiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Appoiment, Long> {
    @Query("SELECT a FROM Appoiment a WHERE a.medics.id =:doctorId and a.dueDate >=:dueDateAp ")
    List<Appoiment> findAllBy(@Param("doctorId") Long doctorId, @Param("dueDateAp") Date dueDateAp);

    @Query("select a FROM Appoiment a where a.patient.id =:patientId and a.id =:appointmentId")
    Appoiment findAppoimentByPatientId(@Param("patientId") Long patientId, @Param("appointmentId") Long appointmentId);
}
