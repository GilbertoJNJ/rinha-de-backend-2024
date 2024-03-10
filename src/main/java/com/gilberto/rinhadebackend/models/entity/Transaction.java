package com.gilberto.rinhadebackend.models.entity;

import com.gilberto.rinhadebackend.models.requests.TransactionForm;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity(name = "tra_transaction")
public class Transaction {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "tra_id")
  private Long id;
  
  @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
  @JoinColumn(name = "tra_customer_id")
  private Customer customer;
  
  @Column(name = "tra_value")
  private BigInteger value;
  
  @Column(name = "tra_type")
  private String type;
  
  @Column(name = "tra_description")
  private String description;
  
  @Column(name = "tra_created_at")
  private LocalDateTime createdAt;
  
  public Transaction(Customer customer, TransactionForm form) {
    this.customer = customer;
    this.value = form.value();
    this.type = form.type();
    this.description = form.description();
    this.createdAt = LocalDateTime.now();
  }
  
  public Transaction() {
  
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public Long getId() {
    return id;
  }
  
  public BigInteger getValue() {
    return value;
  }
  
  public String getType() {
    return type;
  }
  
  public String getDescription() {
    return description;
  }
  
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
  
}
