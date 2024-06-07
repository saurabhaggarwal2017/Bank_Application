package com.syc.finance.v1.bharat.Bank_Application.repository;

import com.syc.finance.v1.bharat.Bank_Application.entity.UpiInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpiRepo extends JpaRepository<UpiInformation,Integer> {
}
