package com.syc.finance.v1.bharat.Bank_Application.repository;

import com.syc.finance.v1.bharat.Bank_Application.entity.TransactionHistoryDetails;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<TransactionHistoryDetails, Integer> {
}
