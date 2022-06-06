package com.api.postnet.services;

import com.api.postnet.dto.AppointmentRequest;
import com.api.postnet.entities.Appointment;
import com.api.postnet.repository.AppointmentRepository;
import com.api.postnet.repository.MedicRepository;
import com.api.postnet.repository.PatientRepository;
import com.api.postnet.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppointmentService {
    private AppointmentRepository appointmentRepository;
    private PrescriptionRepository prescriptionRepository;
    private MedicRepository medicRepository;
    private PatientRepository patientRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, MedicRepository medicRepository, PatientRepository patientRepository,PrescriptionRepository prescriptionRepository){
        this.appointmentRepository=appointmentRepository;
        this.medicRepository=medicRepository;
        this.prescriptionRepository=prescriptionRepository;
        this.patientRepository=patientRepository;
    }

    @Transactional
    public Appointment updatePrescription(Long id,Long prescription_id){
        Appointment appointment= appointmentRepository.findAppointmentById(id);
        appointment.setPrescription(prescriptionRepository.findPrescriptionById(prescription_id));
        return appointment;
    }

    @Transactional
    public Appointment createAppointment(AppointmentRequest appointmentRequest)
    {
        Appointment appointmentNew=initAppoiment(appointmentRequest);
        return appointmentRepository.save(appointmentNew);
    }
    @Transactional
    public List<Appointment> getAppointmentByPatientDni(String patientId){
        return appointmentRepository.findAppointmentByPatientDni(patientId);
    }
    @Transactional
    public Appointment getAppointmentById(Long appointmentid){
        return appointmentRepository.findAppointmentByAppointmentId(appointmentid);
    }
    @Transactional
    public void deleteAppointment(Long id){
        Appointment appointmentToDelete=getAppointmentById(id);
        appointmentRepository.delete(appointmentToDelete);
    }

    private Appointment initAppoiment(AppointmentRequest appointmentRequest){
        Appointment appointmentObj=new Appointment();

        appointmentObj.setMedics(this.medicRepository.findMedicByDni(appointmentRequest.getMedic_dni()));
        appointmentObj.setPatient(this.patientRepository.findPatientByDni(appointmentRequest.getPatient_dni()));
        appointmentObj.setDueDate(appointmentRequest.getDue_date());
        appointmentObj.setStartTime(appointmentRequest.getStart_time());
        appointmentObj.setEndTime(appointmentRequest.getEnd_time());
        appointmentObj.setPaymentMethod(appointmentRequest.getPaymentMethod());
        appointmentObj.setCost(appointmentRequest.getCost());


        return appointmentObj;

    }
}
