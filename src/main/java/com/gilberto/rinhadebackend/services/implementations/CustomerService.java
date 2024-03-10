package com.gilberto.rinhadebackend.services.implementations;

import com.gilberto.rinhadebackend.exceptions.CustomerNotFoundException;
import com.gilberto.rinhadebackend.exceptions.InconsistentBalanceException;
import com.gilberto.rinhadebackend.exceptions.UnsupportedModalityException;
import com.gilberto.rinhadebackend.models.entity.Customer;
import com.gilberto.rinhadebackend.models.requests.TransactionForm;
import com.gilberto.rinhadebackend.models.responses.BalanceDTO;
import com.gilberto.rinhadebackend.models.responses.ExtractDTO;
import com.gilberto.rinhadebackend.models.responses.CustomerDTO;
import com.gilberto.rinhadebackend.repositories.CustomerRepository;
import com.gilberto.rinhadebackend.services.ICustomerService;
import com.gilberto.rinhadebackend.services.ITransactionService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
  
  private final CustomerRepository customerRepository;
  
  private final ITransactionService transactionService;
  
  @Autowired
  public CustomerService(CustomerRepository customerRepository, ITransactionService transactionService) {
    this.customerRepository = customerRepository;
    this.transactionService = transactionService;
  }
  
  @Override
  public CustomerDTO transacts(Long id, TransactionForm form) {
    var customer = findCustomer(id);
    
    setBalance(form, customer);
    var savedCustomer = customerRepository.save(customer);
    
    transactionService.save(customer, form);
    
    return new CustomerDTO(savedCustomer.getLimit(), savedCustomer.getBalance());
  }
  
  @Override
  public ExtractDTO getExtract(Long id) {
    var customer = findCustomer(id);
    
    var transactionList = transactionService.findByCustomer(customer);
    
    var balance = new BalanceDTO(
        customer.getBalance(),
        LocalDateTime.now(),
        customer.getLimit()
    );
    
    return new ExtractDTO(balance, transactionList);
  }
  
  private Customer findCustomer(Long id) {
    return customerRepository.findById(id)
        .orElseThrow(CustomerNotFoundException::new);
  }
  
  private void setBalance(TransactionForm form, Customer customer) {
    switch (form.type()) {
      case "c":
        customer.setBalance(customer.getBalance().add(form.value()));
        break;
      case "d":
        if (customer.getBalance().compareTo(form.value()) < 0) {
          throw new InconsistentBalanceException();
        }
        customer.setBalance(customer.getBalance().subtract(form.value()));
        break;
      default:
        throw new UnsupportedModalityException();
    }
  }
  
}
