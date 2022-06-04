package com.api.postnet.repository;

import com.api.postnet.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    @Query("SELECT o From Appointment o WHERE o.id=:appointmentId")
    Appointment findAppointmentByAppointmentId(@Param("appointmentId") Long appointmentId);
    @Query("SELECT o From Appointment  o WHERE o.patient.dni=:patientDni")
    List<Appointment> findAppointmentByPatientDni(@Param("patientDni") String patientDni);

    Appointment findAppointmentById(Long id);
}
