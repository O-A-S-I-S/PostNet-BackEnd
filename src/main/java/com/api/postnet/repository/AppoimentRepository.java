package com.api.postnet.repository;

import com.api.postnet.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppoimentRepository extends JpaRepository<Appointment,Long> {

    @Query("SELECT o From Appointment o WHERE o.id=:appoimentId")
    Appointment findAppoimentByAppoimentId(@Param("appoimentId") Long appoimentId);
}
