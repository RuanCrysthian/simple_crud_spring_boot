package com.example.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address extends BaseModel {

  @Column(name = "street", nullable = false, length = 80)
  private String street;

  @Column(name = "number", nullable = false, length = 14)
  private String number;

  public Address() {
    super();
  }

  public Address(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String street, String number) {
    super(id, createdAt, updatedAt);
    this.street = street;
    this.number = number;
  }

  public String getStreet() {
    return this.street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Address street(String street) {
    setStreet(street);
    return this;
  }

  public Address number(String number) {
    setNumber(number);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Address)) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(street, address.street) && Objects.equals(number, address.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, number);
  }

  @Override
  public String toString() {
    return "{" +
        " street='" + getStreet() + "'" +
        ", number='" + getNumber() + "'" +
        "}";
  }

}
