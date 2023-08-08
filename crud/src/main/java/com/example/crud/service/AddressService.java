package com.example.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Address;
import com.example.crud.repository.AddressRepository;

@Service
public class AddressService {
  @Autowired
  AddressRepository repository;

  public Address create(Address address) {
    return repository.save(address);
  }

  public List<Address> findAll() {
    return repository.findAll();
  }

  public Address findById(Long id) {
    return repository.findById(id).orElseThrow(() -> new RuntimeException("Address not found!"));
  }

  public Address update(Address address) {
    Address entity = repository.findById(address.getId()).orElseThrow(() -> new RuntimeException("Address not found!"));
    entity.setStreet(address.getStreet());
    entity.setNumber(address.getNumber());
    return repository.save(entity);
  }

  public void delete(Long id) {
    Address entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Address not Found!"));
    repository.delete(entity);
  }
}
