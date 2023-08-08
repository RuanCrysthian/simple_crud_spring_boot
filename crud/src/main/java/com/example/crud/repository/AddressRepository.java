package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
