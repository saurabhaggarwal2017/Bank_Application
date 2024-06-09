package com.syc.finance.v1.bharat.Bank_Application.repository;

import com.syc.finance.v1.bharat.Bank_Application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {
    Optional<User> findByContactPhoneNumberAndContactEmail(String contactPhoneNumber, String contactEmail);
    Optional<User> findByContactPhoneNumber(String contactPhoneNumber);
}
