package com.api.postnet.repository;

import com.api.postnet.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    @Query("SELECT o From Appointment o WHERE o.id=:appointmentId")
    Appointment findAppoimentByAppointmentId(@Param("appointmentId") Long appointmentId);
}