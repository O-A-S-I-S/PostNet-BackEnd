package com.oasis.postnet.services;

import com.oasis.postnet.entities.Person;
import com.oasis.postnet.repository.LogInRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogInService {
        private LogInRepository logInRepository;

        public LogInService(LogInRepository logInRepository){
            this.logInRepository = logInRepository;
        }

        @Transactional(readOnly = true)
        public Person findPersonByDni(String dni){
            return logInRepository.findPersonByDni(dni);
        }
}
