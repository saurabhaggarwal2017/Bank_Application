package com.syc.finance.v1.bharat.Bank_Application.services.AccountService;

import com.syc.finance.v1.bharat.Bank_Application.dto.user.UserRequestDto;
import com.syc.finance.v1.bharat.Bank_Application.dto.user.UserResponseDto;

public interface AccountService {
    UserResponseDto createAccount(UserRequestDto userRequestDto);
//    void updateAccountDetails();
//    void deleteAccount();
//    void findAccountByAccountNumber();

}
