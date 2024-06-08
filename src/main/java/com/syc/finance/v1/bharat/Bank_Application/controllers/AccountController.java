package com.syc.finance.v1.bharat.Bank_Application.controllers;

import com.syc.finance.v1.bharat.Bank_Application.dto.user.UserRequestDto;
import com.syc.finance.v1.bharat.Bank_Application.dto.user.UserResponseDto;
import com.syc.finance.v1.bharat.Bank_Application.services.AccountService.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("finance/v1/bank/v4/bharat")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private final AccountService accountService;

    @PostMapping("/create-account")
    public ResponseEntity<UserResponseDto> createAccount(@Valid @RequestBody UserRequestDto userRequestDto) {
//        TODO: do validation of dto.
        UserResponseDto response = accountService.createAccount(userRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
