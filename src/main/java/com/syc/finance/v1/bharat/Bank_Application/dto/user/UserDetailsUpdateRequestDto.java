package com.syc.finance.v1.bharat.Bank_Application.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailsUpdateRequestDto {
    private String accountHolderName;
    private String oldContactPhoneNumber;
    private String contactPhoneNumber;
    private String contactEmail;
    private String gender;
    private String accountType;
    private String address;
    private String pinCodeNumber;
    private String state;
}
