package com.oasis.postnet.repository;

import com.oasis.postnet.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogInRepository extends JpaRepository<Person, String> {
    Person findPersonByDni(String dni);
}
