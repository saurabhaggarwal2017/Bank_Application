package com.syc.finance.v1.bharat.Bank_Application.controllers;

import com.syc.finance.v1.bharat.Bank_Application.dto.user.*;
import com.syc.finance.v1.bharat.Bank_Application.services.AccountService.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("finance/v1/bank/v4/bharat")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private final AccountService accountService;

    @PostMapping("/create-account")
    public ResponseEntity<UserCreateResponseDto> createAccount(@Valid @RequestBody UserCreateRequestDto userCreateRequestDto) {
//        TODO: do validation of dto.
        UserCreateResponseDto response = accountService.createAccount(userCreateRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update-account-details")
    public ResponseEntity<UserDetailsUpdateResponseDto> updateAccountDetails(
            @RequestParam String accountNumber,
            @RequestParam String ifscCode,
            @RequestBody UserDetailsUpdateRequestDto userDetailsUpdateRequestDto) {
        UserDetailsUpdateResponseDto response = accountService.updateAccountDetails(accountNumber, ifscCode, userDetailsUpdateRequestDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete-account")
    public ResponseEntity<UserDeleteResonseDto> deleteAccount(@RequestBody UserDeleteRequestDto userDeleteRequestDto) {
        UserDeleteResonseDto response = accountService.deleteAccount(userDeleteRequestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-account-details")
    public ResponseEntity<UserAccountResponseDto> getAccountDetails(@RequestBody UserAccountRequestDto userAccountRequestDto) {
        UserAccountResponseDto response = accountService.getAccountDetails(userAccountRequestDto);
        return ResponseEntity.ok(response);
    }

}
