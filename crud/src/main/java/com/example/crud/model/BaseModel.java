package com.example.crud.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Objects;

@MappedSuperclass
public abstract class BaseModel implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonProperty("created_at")
  @CreationTimestamp
  @Column(name = "created_at", nullable = false, length = 80)
  private LocalDateTime createdAt;

  @JsonProperty("updated_at")
  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false, length = 80)
  private LocalDateTime updatedAt;

  public BaseModel() {
  }

  public BaseModel(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public BaseModel id(Long id) {
    setId(id);
    return this;
  }

  public BaseModel createdAt(LocalDateTime createdAt) {
    setCreatedAt(createdAt);
    return this;
  }

  public BaseModel updatedAt(LocalDateTime updatedAt) {
    setUpdatedAt(updatedAt);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof BaseModel)) {
      return false;
    }
    BaseModel baseModel = (BaseModel) o;
    return Objects.equals(id, baseModel.id) && Objects.equals(createdAt, baseModel.createdAt)
        && Objects.equals(updatedAt, baseModel.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", createdAt='" + getCreatedAt() + "'" +
        ", updatedAt='" + getUpdatedAt() + "'" +
        "}";
  }

}
