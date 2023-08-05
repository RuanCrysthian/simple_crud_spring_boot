package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.Person;
import com.example.crud.service.PersonService;

@RestController
@RequestMapping("/persons")
@Qualifier("personController")
public class PersonController {
  @Autowired
  private PersonService service;

  @PostMapping(produces = { "application/json", "application/xml" }, consumes = { "application/json",
      "application/xml" })
  public Person create(@RequestBody Person person) {
    return service.create(person);
  }

  @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  public List<Person> findAll() {
    return service.findAll();
  }

  @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  public Person findById(@PathVariable(value = "id") Long id) throws Exception {
    return service.findById(id);
  }

  @PutMapping(produces = { "application/json", "application/xml" }, consumes = { "application/json",
      "application/xml" })
  public Person update(@RequestBody Person person) {
    return service.update(person);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    service.delete(id);
    return ResponseEntity.ok().build();
  }

}
