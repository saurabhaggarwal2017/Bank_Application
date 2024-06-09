package com.syc.finance.v1.bharat.Bank_Application.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDeleteResonseDto {
    private String accountHolderName;
    private String accountNumber;
    private String contactPhoneNumber;
    private String message;
}
