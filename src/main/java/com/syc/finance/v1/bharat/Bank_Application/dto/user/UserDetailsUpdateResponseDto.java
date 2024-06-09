package com.syc.finance.v1.bharat.Bank_Application.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.BatchUpdateException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailsUpdateResponseDto {
    private String accountHolderName;
    private String contactPhoneNumber;
    private String contactEmail;
    private String gender;
    private String address;
    private String pinCodeNumber;
    private String county;
    private String state;

    private String accountType;
    private String accountNumber;

}
