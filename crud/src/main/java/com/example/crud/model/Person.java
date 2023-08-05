package com.example.crud.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "person")
@JsonPropertyOrder({ "id", "name", "cpf", "createdAt", "updatedAt" })
public class Person extends BaseModel {

  @Column(name = "name", nullable = false, length = 80)
  private String name;
  @Column(name = "cpf", nullable = false, length = 80)
  private String cpf;

  public Person() {
    super();
  }

  public Person(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String cpf) {
    super(id, createdAt, updatedAt);
    this.name = name;
    this.cpf = cpf;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Person(String name, String cpf) {
    this.name = name;
    this.cpf = cpf;
  }

  public Person name(String name) {
    setName(name);
    return this;
  }

  public Person cpf(String cpf) {
    setCpf(cpf);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Person)) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(name, person.name) && Objects.equals(cpf, person.cpf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, cpf);
  }

  @Override
  public String toString() {
    return "{" +
        " name='" + getName() + "'" +
        ", cpf='" + getCpf() + "'" +
        "}";
  }

}
