package com.api.postnet.services;

import com.api.postnet.entities.Appoiment;
import com.api.postnet.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DoctorService {
    private ScheduleRepository scheduleRepository;

    public DoctorService(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    @Transactional(readOnly = true)
    public List<Appoiment> getAllAppoimentsById(Long doctorId, Date dueDateAp){
        return scheduleRepository.findAllBy(doctorId, dueDateAp);
    }
}
