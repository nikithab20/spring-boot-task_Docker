package com.family.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.family.service.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByPersonName(String personName);
    Person findByPersonId(Integer personId);
    
}
