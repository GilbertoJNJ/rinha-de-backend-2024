package com.gilberto.rinhadebackend.exceptions;

import org.springframework.http.HttpStatus;

public class InconsistentBalanceException extends RuntimeException {
  private final HttpStatus status;
  
  public InconsistentBalanceException() {
    super("Saldo inconsistente.");
    this.status = HttpStatus.UNPROCESSABLE_ENTITY;
  }
  
  public HttpStatus getStatus() {
    return status;
  }
  
}
