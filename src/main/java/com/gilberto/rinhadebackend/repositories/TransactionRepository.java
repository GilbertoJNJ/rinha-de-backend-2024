package com.gilberto.rinhadebackend.repositories;

import com.gilberto.rinhadebackend.models.entity.Customer;
import com.gilberto.rinhadebackend.models.entity.Transaction;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  
  @Query("SELECT t FROM tra_transaction t " +
      "WHERE t.customer = :customer " +
      "ORDER BY t.createdAt DESC")
  List<Transaction> findAllByCustomer(@Param("customer") Customer customer, Pageable pageble);
  
}
