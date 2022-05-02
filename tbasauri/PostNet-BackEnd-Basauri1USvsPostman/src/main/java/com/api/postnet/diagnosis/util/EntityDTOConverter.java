package com.api.postnet.diagnosis.util;

import com.api.postnet.diagnosis.dto.OrderResponse;
import com.api.postnet.diagnosis.entities.medic_appointment;
import jdk.jshell.Diag;
import org.modelmapper.ModelMapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class EntityDTOConverter {

    private ModelMapper modelMapper;
    EntityDTOConverter(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public OrderResponse convertEntityToDto(medic_appointment order){
        return modelMapper.map(order, OrderResponse.class);
    }

    public List<OrderResponse> convertEntityToDto (List<medic_appointment> orders){
        return orders.stream()
                .map(order->convertEntityToDto(order))
                .collect(Collectors.toList());
    }
}
