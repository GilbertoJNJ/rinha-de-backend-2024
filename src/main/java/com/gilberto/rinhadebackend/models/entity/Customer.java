package com.gilberto.rinhadebackend.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigInteger;

@Entity(name = "cus_customer")
public class Customer {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cus_id")
  private Long id;
  
  @Column(name = "cus_balance")
  private BigInteger balance;
  
  @Column(name = "cus_limit")
  private BigInteger limit;
  
  public BigInteger getBalance() {
    return balance;
  }
  
  public BigInteger getLimit() {
    return limit;
  }
  
  public void setBalance(BigInteger balance) {
    this.balance = balance;
  }
  
}
