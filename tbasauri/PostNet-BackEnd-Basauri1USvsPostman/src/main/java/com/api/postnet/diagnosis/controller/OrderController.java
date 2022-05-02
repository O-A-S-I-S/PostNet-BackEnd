package com.api.postnet.diagnosis.controller;

import com.api.postnet.diagnosis.Service.OrderService;
import com.api.postnet.diagnosis.dto.OrderRequest;
import com.api.postnet.diagnosis.dto.OrderResponse;
import com.api.postnet.diagnosis.entities.Appointment;
import com.api.postnet.diagnosis.entities.medic_appointment;
import com.api.postnet.diagnosis.entities.Medic;
import com.api.postnet.diagnosis.util.EntityDTOConverter;
import org.apache.coyote.Response;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/response1")
public class OrderController {

    private OrderService orderService;
    private EntityDTOConverter converter;
    public OrderController(OrderService orderService, EntityDTOConverter converter){
        this.orderService = orderService;
        this.converter = converter;
    }

    /*@GetMapping
    public ResponseEntity<List<OrderResponse>> findAllOrdenes(){
        List<OrderResponse> ordenes = new ArrayList<>();

        OrderResponse response_01 = new OrderResponse();
        response_01.setClinicHistoryID("1234");
        response_01.setPatientID("75260947");
        response_01.setDiagnosisID("D001");

        OrderResponse response_02 = new OrderResponse();
        response_02.setClinicHistoryID("1234");
        response_02.setPatientID("75260947");
        response_02.setDiagnosisID("D002");

        ordenes.add(response_01);
        ordenes.add(response_02);

        return new ResponseEntity(ordenes, HttpStatus.OK);
    }*/
/*
    @GetMapping("/{ClinicHistoryID}")
    public ResponseEntity<OrderResponse> findOrderByID(@PathVariable String ClinicHistoryID){
        OrderResponse response_01 = new OrderResponse();
        response_01.setClinicHistoryID(ClinicHistoryID);
        response_01.setPatientID("75260947");
        response_01.setDiagnosisID("D001");

        return new ResponseEntity(response_01, HttpStatus.OK);
    }
*/
    /*@PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request){*/
        /*OrderResponse response_01 = new OrderResponse();
        response_01.setClinicHistoryID("1234");
        response_01.setPatientID("75260947");
        response_01.setDiagnosisID(request.getDiagnosisID());
        */
        /*Diagnosis diagnosis = orderService.createOrder(request);

        return new ResponseEntity(converter.convertEntityToDto(diagnosis), HttpStatus.CREATED);
    }*/

    public Boolean criterio(medic_appointment order, String something){
        /*OrderResponse novo = new OrderResponse();
        if(order.getMedic().getPerson_id() == something){
            novo.setMedic(order.getMedic());
            novo.setAppointment(order.getAppointment());
        }*/
        return order.getMedic().getPerson_id().equals(something) ;
    }


    public List<medic_appointment> filtrado (List<medic_appointment> orders, String something){
        return orders.stream()
                .filter(order->criterio(order, something))
                .collect(Collectors.toList());
    }


    @GetMapping("/{person_id}")
    public ResponseEntity<List<OrderResponse>> findOrderByID(@PathVariable String person_id) {
        List<medic_appointment> citas = new ArrayList<>();

        Medic medic1 = new Medic();
        medic1.setPerson_id("123");
        medic1.setSpecialty_id(1);

        Medic medic2 = new Medic();
        medic2.setSpecialty_id(2);
        medic2.setPerson_id("7765342");

        Appointment appointment1 = new Appointment();
        appointment1.setAppointment_id(1);
        appointment1.setDue_date(new Date());

        Appointment appointment2 = new Appointment();
        appointment2.setAppointment_id(2);
        appointment2.setDue_date(new Date());

        Appointment appointment3 = new Appointment();
        appointment3.setAppointment_id(3);
        appointment3.setDue_date(new Date());

        Appointment appointment4 = new Appointment();
        appointment4.setAppointment_id(4);
        appointment4.setDue_date(new Date());

        Appointment appointment5 = new Appointment();
        appointment5.setAppointment_id(5);
        appointment5.setDue_date(new Date());

        Appointment appointment6 = new Appointment();
        appointment6.setAppointment_id(6);
        appointment6.setDue_date(new Date());

        medic_appointment medic_appointment1 = new medic_appointment();
        medic_appointment1.setAppointment(appointment1);
        medic_appointment1.setMedic(medic1);
        citas.add(medic_appointment1);


        medic_appointment medic_appointment2 = new medic_appointment();
        medic_appointment2.setAppointment(appointment2);
        medic_appointment2.setMedic(medic1);
        citas.add(medic_appointment2);

        medic_appointment medic_appointment3 = new medic_appointment();
        medic_appointment3.setAppointment(appointment3);
        medic_appointment3.setMedic(medic1);
        citas.add(medic_appointment3);


        medic_appointment medic_appointment4 = new medic_appointment();
        medic_appointment4.setAppointment(appointment4);
        medic_appointment4.setMedic(medic2);
        citas.add(medic_appointment4);


        medic_appointment medic_appointment5 = new medic_appointment();
        medic_appointment5.setAppointment(appointment5);
        medic_appointment5.setMedic(medic2);
        citas.add(medic_appointment5);

        //List<medic_appointment> ordenes = new ArrayList<>();
        //ordenes = filtrado(citas, person_id);
        List<medic_appointment> ordenes = filtrado(citas, person_id);


        return new ResponseEntity(converter.convertEntityToDto(ordenes), HttpStatus.OK);
    }
}
