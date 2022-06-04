package com.api.postnet.services;

import com.api.postnet.dto.SpecialityRequest;
import com.api.postnet.entities.Speciality;
import com.api.postnet.repository.SpecialityRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SpecialityService {
    private SpecialityRepository specialityRepository;

    public SpecialityService(SpecialityRepository specialityRepository){this.specialityRepository=specialityRepository;}
    @Transactional
    public Speciality createSpeciality(SpecialityRequest specialityRequest) {
        Speciality specialityNew = initSpeciality(specialityRequest);
        return specialityRepository.save(specialityNew);
    }

    private Speciality initSpeciality(SpecialityRequest specialityRequest) {
        Speciality speciality = new Speciality();
        speciality.setName(specialityRequest.getName());
        return speciality;
    }

    @Transactional
    public Speciality getSpecialityByName(String name)
    {
        return specialityRepository.findSpecialityByName(name);
    }
}
