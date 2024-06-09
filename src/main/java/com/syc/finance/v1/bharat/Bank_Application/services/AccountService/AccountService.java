package com.syc.finance.v1.bharat.Bank_Application.services.AccountService;

import com.syc.finance.v1.bharat.Bank_Application.dto.user.UserCreateRequestDto;
import com.syc.finance.v1.bharat.Bank_Application.dto.user.UserCreateResponseDto;
import com.syc.finance.v1.bharat.Bank_Application.dto.user.UserDetailsUpdateRequestDto;
import com.syc.finance.v1.bharat.Bank_Application.dto.user.UserDetailsUpdateResponseDto;

public interface AccountService {
    UserCreateResponseDto createAccount(UserCreateRequestDto userCreateRequestDto);
    UserDetailsUpdateResponseDto updateAccountDetails(String accountNumber, String ifscCode, UserDetailsUpdateRequestDto requestDto);
//    void deleteAccount();
//    void findAccountByAccountNumber();

}
