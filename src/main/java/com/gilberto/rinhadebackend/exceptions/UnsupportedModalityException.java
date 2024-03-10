package com.gilberto.rinhadebackend.exceptions;

import org.springframework.http.HttpStatus;

public class UnsupportedModalityException extends RuntimeException {
  private final HttpStatus status;
  
  public UnsupportedModalityException() {
    super("Modalidade não suportada.");
    this.status = HttpStatus.UNPROCESSABLE_ENTITY;
  }
  
  public HttpStatus getStatus() {
    return status;
  }
  
}
