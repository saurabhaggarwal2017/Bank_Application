package com.syc.finance.v1.bharat.Bank_Application.services.AccountService;

import com.syc.finance.v1.bharat.Bank_Application.dto.user.*;

public interface AccountService {
    UserCreateResponseDto createAccount(UserCreateRequestDto userCreateRequestDto);
    UserDetailsUpdateResponseDto updateAccountDetails(String accountNumber, String ifscCode, UserDetailsUpdateRequestDto requestDto);
    UserDeleteResonseDto deleteAccount(UserDeleteRequestDto requestDto);
    UserAccountResponseDto getAccountDetails(UserAccountRequestDto requestDto);

}
