package com.syc.finance.v1.bharat.Bank_Application.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
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
    private String ifscCode;
    private String bankName;
    private String branchCode;
    private String bankBranchName;
    private int accountBalance;

}
