package com.gilberto.rinhadebackend.services;

import com.gilberto.rinhadebackend.models.entity.Customer;
import com.gilberto.rinhadebackend.models.requests.TransactionForm;
import com.gilberto.rinhadebackend.models.responses.TransactionDTO;
import java.util.List;

public interface ITransactionService {
  
  void save(Customer customer, TransactionForm form);
  
  List<TransactionDTO> findByCustomer(Customer customer);
  
}
