package com.example.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Person;
import com.example.crud.repository.PersonRepository;

@Service
public class PersonService {
  @Autowired
  PersonRepository repository;

  public Person create(Person person) {
    return repository.save(person);
  }

  public List<Person> findAll() {
    return repository.findAll();
  }

  public Person findById(Long id) {
    return repository.findById(id).orElseThrow(() -> new RuntimeException("Person not found!"));
  }

  public Person update(Person person) {
    Person entity = repository.findById(person.getId()).orElseThrow(() -> new RuntimeException("Person not found!"));
    entity.setName(person.getName());
    entity.setCpf(person.getCpf());
    return repository.save(entity);
  }

  public void delete(Long id) {
    Person entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Person not Found!"));
    repository.delete(entity);
  }
}
