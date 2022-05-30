package com.api.postnet.services;

import com.api.postnet.entities.Prescription;
import com.api.postnet.exceptions.AppointmentNotFoundException;
import com.api.postnet.repository.MedicineRepository;
import com.api.postnet.repository.PrescriptionRepository;
import com.api.postnet.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientService {
    private PrescriptionRepository prescriptionRepository;
    private MedicineRepository medicineRepository;
    private ScheduleRepository scheduleRepository;
    public PatientService(PrescriptionRepository prescriptionRepository, MedicineRepository medicineRepository, ScheduleRepository scheduleRepository){
        this.prescriptionRepository = prescriptionRepository;
        this.medicineRepository = medicineRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Transactional(readOnly = true)
    public List<Prescription> findPatientPrescription(Long patientId,Long appointmentId){
        ValidatePatientAppointment(patientId, appointmentId);
        return prescriptionRepository.findPrescriptionsByAppoimentId(appointmentId);
    }

    public boolean ValidatePatientAppointment(Long patientId, Long appointmentId){
        if(scheduleRepository.findAppoimentByPatientId(patientId,appointmentId) == null){
            throw new AppointmentNotFoundException("El paciente no cuenta con ese número de cita creada.");
        }
        return true;
    }

}
