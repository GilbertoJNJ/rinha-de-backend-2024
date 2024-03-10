package com.gilberto.rinhadebackend.services;

import com.gilberto.rinhadebackend.models.requests.TransactionForm;
import com.gilberto.rinhadebackend.models.responses.ExtractDTO;
import com.gilberto.rinhadebackend.models.responses.CustomerDTO;

public interface ICustomerService {
  
  CustomerDTO transacts(Long id, TransactionForm form);
  
  ExtractDTO getExtract(Long id);
  
}
