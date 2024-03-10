package com.gilberto.rinhadebackend.services.implementations;

import com.gilberto.rinhadebackend.models.entity.Customer;
import com.gilberto.rinhadebackend.models.entity.Transaction;
import com.gilberto.rinhadebackend.models.requests.TransactionForm;
import com.gilberto.rinhadebackend.models.responses.TransactionDTO;
import com.gilberto.rinhadebackend.repositories.TransactionRepository;
import com.gilberto.rinhadebackend.services.ITransactionService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService {
  
  private final TransactionRepository transactionRepository;
  
  @Autowired
  public TransactionService(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }
  
  @Override
  public void save(Customer customer, TransactionForm form) {
    var transaction = new Transaction(customer, form);
    transactionRepository.save(transaction);
  }
  
  @Override
  public List<TransactionDTO> findByCustomer(Customer customer) {
    return transactionRepository.findAllByCustomer(customer, Pageable.ofSize(10)).stream()
        .map(transaction -> new TransactionDTO(
            transaction.getValue(),
            transaction.getType(),
            transaction.getDescription(),
            transaction.getCreatedAt()))
        .collect(Collectors.toList());
  }
  
}
