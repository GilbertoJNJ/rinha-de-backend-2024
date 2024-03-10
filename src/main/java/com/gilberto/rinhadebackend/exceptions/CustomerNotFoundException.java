package com.gilberto.rinhadebackend.exceptions;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends RuntimeException {
  
  private final HttpStatus status;
  
  public CustomerNotFoundException() {
    super("Cliente não encontrado.");
    this.status = HttpStatus.NOT_FOUND;
  }
  
  public HttpStatus getStatus() {
    return status;
  }
  
}
