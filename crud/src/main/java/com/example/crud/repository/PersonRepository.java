package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crud.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
