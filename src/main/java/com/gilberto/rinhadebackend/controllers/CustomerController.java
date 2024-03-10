package com.gilberto.rinhadebackend.controllers;

import com.gilberto.rinhadebackend.exceptions.CustomerNotFoundException;
import com.gilberto.rinhadebackend.exceptions.InconsistentBalanceException;
import com.gilberto.rinhadebackend.exceptions.UnsupportedModalityException;
import com.gilberto.rinhadebackend.models.requests.TransactionForm;
import com.gilberto.rinhadebackend.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class CustomerController {
  
  private final ICustomerService customerService;
  
  @Autowired
  public CustomerController(ICustomerService customerService) {
    this.customerService = customerService;
  }
  
  @PostMapping("/{id}/transacoes")
  public ResponseEntity<Object> transacts(@PathVariable Long id,
                                          @RequestBody TransactionForm form) {
    try {
      return ResponseEntity.ok(customerService.transacts(id, form));
    } catch (CustomerNotFoundException exception) {
      return ResponseEntity.status(exception.getStatus())
          .body(exception.getMessage());
    } catch (InconsistentBalanceException exception) {
      return ResponseEntity.status(exception.getStatus())
          .body(exception.getMessage());
    } catch (UnsupportedModalityException exception) {
      return ResponseEntity.status(exception.getStatus())
          .body(exception.getMessage());
    }
  }
  
  @GetMapping("/{id}/extrato")
  public ResponseEntity<Object> getExtract(@PathVariable Long id) {
    try {
      return ResponseEntity.ok(customerService.getExtract(id));
    } catch (CustomerNotFoundException exception) {
      return ResponseEntity.status(exception.getStatus())
          .body(exception.getMessage());
    }
  }
  
}
